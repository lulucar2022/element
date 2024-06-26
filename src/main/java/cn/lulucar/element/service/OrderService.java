package cn.lulucar.element.service;

import cn.lulucar.element.entity.Order;
import cn.lulucar.element.model.dto.Order4FoodDTO;
import cn.lulucar.element.model.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName OrderService
 * @date 2024/6/22 10:10
 * @description
 */
@Service
public interface OrderService {
    Integer createOrder(Order order);

    OrderDTO getOrdersById(Integer orderId);

    List<Order4FoodDTO> listOrdersByUserId(String userId);
    
    Integer updateOrderState(Integer orderId, Integer orderState);
}
