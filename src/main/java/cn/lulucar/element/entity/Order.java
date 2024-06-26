package cn.lulucar.element.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wenxiaolan
 * @ClassName Orders
 * @date 2024/6/17 14:36
 * @description
 */
@Data
@Schema(description = "订单信息",title = "订单实体类")
public class Order {
    @Schema(description = "订单编号，主键，自增")
    private Integer orderId; // 订单编号，主键，自增  
    @Schema(description = "用户编号")
    private String userId; // 用户编号  
    
    @Schema(description = "商家编号")
    private Integer businessId; // 商家编号  
    
    @Schema(description = "订购日期")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate; // 订购日期（通常建议使用日期类型如java.time.LocalDate）  
    
    @Schema(description = "订单总价")
    private BigDecimal orderTotal; // 订单总价  
    
    @Schema(description = "送货地址编号")
    private Integer daId; // 送货地址编号  
    
    @Schema(description = "订单状态（0：未支付； 1：已支付）")
    private Integer orderState; // 订单状态（0：未支付； 1：已支付）  
}
