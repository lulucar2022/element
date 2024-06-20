package cn.lulucar.element.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wenxiaolan
 * @ClassName Orders
 * @date 2024/6/17 14:36
 * @description
 */
@Data
@Schema(description = "订单信息",title = "订单管理")
public class Orders {
    private Integer orderId; // 订单编号，主键，自增  

    private String userId; // 用户编号  

    private Integer businessId; // 商家编号  

    private LocalDateTime orderDate; // 订购日期（通常建议使用日期类型如java.time.LocalDate）  

    private BigDecimal orderTotal; // 订单总价  

    private Integer daId; // 送货地址编号  

    private Integer orderState; // 订单状态（0：未支付； 1：已支付）  
}
