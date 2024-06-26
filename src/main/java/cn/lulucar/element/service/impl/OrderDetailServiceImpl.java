package cn.lulucar.element.service.impl;

import cn.lulucar.element.entity.Food;
import cn.lulucar.element.entity.OrderDetail;
import cn.lulucar.element.mapper.OrderDetailMapper;
import cn.lulucar.element.model.dto.OrderDetailDTO;
import cn.lulucar.element.service.FoodService;
import cn.lulucar.element.service.OrderDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenxiaolan
 * @ClassName OrderDetailServiceImpl
 * @date 2024/6/26 9:24
 * @description
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailMapper orderDetailMapper;
    private final FoodService foodService;
    public OrderDetailServiceImpl(OrderDetailMapper orderDetailMapper, FoodService foodService) {
        this.orderDetailMapper = orderDetailMapper;
        this.foodService = foodService;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public List<OrderDetailDTO> getOrderDetailList(Integer orderId) {
        List<OrderDetail> orderDetailList = orderDetailMapper.listOrderDetailByOrderId(orderId);
        return orderDetailList.stream().map(orderDetail -> {
            OrderDetailDTO detailDTO = new OrderDetailDTO();
            BeanUtils.copyProperties(orderDetail, detailDTO);
            Food food = foodService.getFoodById(orderDetail.getFoodId());
            detailDTO.setFood(food);
            return detailDTO;
        }).collect(Collectors.toList());
    }
}
