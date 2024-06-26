package cn.lulucar.element.controller;

import cn.lulucar.element.entity.Order;
import cn.lulucar.element.model.dto.Order4FoodDTO;
import cn.lulucar.element.model.dto.OrderDTO;
import cn.lulucar.element.model.dto.OrderNoIdDTO;
import cn.lulucar.element.model.dto.OrderStateDTO;
import cn.lulucar.element.service.OrderService;
import cn.lulucar.element.model.vo.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wenxiaolan
 * @ClassName OrderController
 * @date 2024/6/22 11:11
 * @description
 */
@Tag(name = "订单管理")
@RestController
@RequestMapping("/OrderController")
public class OrderController {
    @Resource
    private OrderService orderService;
    
    @Operation(summary = "创建订单")
    @PostMapping("/createOrder")
    public Result<Integer> createOrders(@RequestBody OrderNoIdDTO orderNoIdDTO) {
        
        Order order = new Order();
        try {
            BeanUtils.copyProperties(orderNoIdDTO, order);
        } catch (BeansException e) {
            throw new RuntimeException(e);
        }
        Integer i = orderService.createOrder(order);
        return Result.<Integer>builder()
                .data(i)
                .build();
    }
    
    @Operation(summary = "根据订单ID获取单个订单信息")
    @GetMapping("/getOrdersById")
    public Result<OrderDTO> getOrdersById(@RequestParam("orderId") Integer orderId) {
        OrderDTO orderDTO = orderService.getOrdersById(orderId);
        return Result.<OrderDTO>builder()
                .data(orderDTO)
                .build();
    }
    
    @Operation(summary = "根据用户ID 获取订单列表")
    @GetMapping("/listOrdersByUserId")
    public Result<List<Order4FoodDTO>> listOrdersByUserId(@RequestParam("userId") String userId) {
        List<Order4FoodDTO> order4FoodDTOS = orderService.listOrdersByUserId(userId);
        
        return Result.<List<Order4FoodDTO>>builder()
                .data(order4FoodDTOS)
                .build();
    }
    
    @Operation(summary = "根据订单ID，更新订单状态，即用户支付订单")
    @PatchMapping("/order")
    public Result<Integer> confirmPayment(@RequestBody OrderStateDTO orderStateDTO) {
        Integer updated = orderService.updateOrderState(orderStateDTO.getOrderId(), orderStateDTO.getOrderState());
        return Result.<Integer>builder()
                .data(updated)
                .build();
    }
    
}
