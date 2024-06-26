package cn.lulucar.element.service.impl;

import cn.lulucar.element.entity.*;
import cn.lulucar.element.mapper.*;
import cn.lulucar.element.model.dto.Order4FoodDTO;
import cn.lulucar.element.model.dto.OrderDTO;
import cn.lulucar.element.model.dto.OrderDetailDTO;
import cn.lulucar.element.service.FoodService;
import cn.lulucar.element.service.OrderDetailService;
import cn.lulucar.element.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenxiaolan
 * @ClassName OrderServiceImpl
 * @date 2024/6/22 10:15
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final CartMapper cartMapper;
    private final BusinessMapper businessMapper;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;
    private final OrderDetailService orderDetailService;

    public OrderServiceImpl(CartMapper cartMapper, BusinessMapper businessMapper, OrderMapper orderMapper, OrderDetailMapper orderDetailMapper, OrderDetailService orderDetailService, FoodService foodService) {
        this.cartMapper = cartMapper;
        this.businessMapper = businessMapper;
        this.orderMapper = orderMapper;
        this.orderDetailMapper = orderDetailMapper;
        this.orderDetailService = orderDetailService;
    }

    /**
     * 创建订单
     * 1.查询用户购物车的商品信息，放到订单详细中
     * 2.创建订单，并返回一个订单Id
     * 3.用订单Id，创建订单详情
     * 4.删除本次购物车中的记录
     * @param order
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer createOrder(Order order) {
        // 1.查询用户购物车的商品信息，放到订单详细中
        List<Cart> cartList = cartMapper.listCart(order.getUserId(),order.getBusinessId());
        // 2.创建订单，并返回一个订单Id
        // 2.1 设置订单时间
        // 2.2 设置订单状态，0：未支付，1：已支付
        order.setOrderDate(LocalDateTime.now());
        order.setOrderState(0);
        orderMapper.insertOrder(order);
        Integer orderId = order.getOrderId();
        // 3.用订单Id，创建订单详情
        List<OrderDetail> orderDetailList = new ArrayList<>();
        cartList.forEach(cart -> {
            OrderDetail od = new OrderDetail();
            od.setOrderId(orderId);
            od.setFoodId(cart.getFoodId());
            od.setQuantity(cart.getQuantity());
            orderDetailList.add(od);
        });
        orderDetailMapper.insertOrderDetail(orderDetailList);
        // 4.删除本次购物车中的记录
        cartMapper.deleteCart(null,order.getBusinessId(),order.getUserId());
        
        return orderId;
    }

    /**
     * 根据orderId获取订单
     * 1. 包括 订单详细
     * 1.1 订单详细包含了订单中的菜品id
     * 2. 包括 商家的信息
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO getOrdersById(Integer orderId) {
        // 1.获取订单
        Order order = orderMapper.selectOrderById(orderId);
        // 2.拿到属于orderId的订单详细
        List<OrderDetailDTO> orderDetailDTOS = orderDetailService.listOrderDetail(orderId);

        Business business = businessMapper.selectByBusinessId(order.getBusinessId());
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order,orderDTO);
        orderDTO.setBusiness(business);
        orderDTO.setOrderDetails(orderDetailDTOS);
        return orderDTO;
    }


    /**
     * 根据用户Id获取订单列表
     * 1. 包括 订单详细列表
     * 1.1 订单详细列表中包含了菜品列表
     * 2. 包括 商家信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<Order4FoodDTO> listOrdersByUserId(String userId) {
        List<Order> orderList = orderMapper.listOrderByUserId(userId);
        List<Order4FoodDTO> orderDTOList;
        orderDTOList = orderList.stream().map(order -> {
            Order4FoodDTO orderDTO = new Order4FoodDTO();
            BeanUtils.copyProperties(order,orderDTO);
            orderDTO.setBusiness(businessMapper.selectByBusinessId(order.getBusinessId()));
            orderDTO.setOrderDetails(orderDetailService.listOrderDetail(order.getOrderId()));
            return orderDTO;
        }).collect(Collectors.toList());
        return orderDTOList;
    }

    /**
     * 更新订单状态
     * 用户支付订单
     * @param orderId 订单id
     * @param orderState 订单的支付状态，0：未支付，1：已支付
     * @return 影响行数
     */
    @Override
    public Integer updateOrderState(Integer orderId, Integer orderState) {
        return orderMapper.updateOrderState(orderId, orderState);
    }
}
