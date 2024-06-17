package cn.lulucar.element.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wenxiaolan
 * @ClassName Orders
 * @date 2024/6/17 14:36
 * @description
 */
@Data
public class Orders {
    private Integer orderId; // 订单编号，主键，自增  

    private String userId; // 用户编号  

    private Integer businessId; // 商家编号  

    private String orderDate; // 订购日期（通常建议使用日期类型如java.time.LocalDate）  

    private BigDecimal orderTotal; // 订单总价  

    private Integer daId; // 送货地址编号  

    private Integer orderState; // 订单状态（0：未支付； 1：已支付）  
}
