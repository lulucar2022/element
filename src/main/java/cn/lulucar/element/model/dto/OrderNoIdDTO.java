package cn.lulucar.element.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wenxiaolan
 * @ClassName OrderNoIdDTO
 * @date 2024/6/23 9:23
 * @description
 */
@Data
@Validated
public class OrderNoIdDTO {
    @NotNull
    private String userId; // 用户编号  
    @NotNull
    private Integer businessId; // 商家编号  
    
    @NotNull
    private BigDecimal orderTotal; // 订单总价  
    @NotNull
    private Integer daId; // 送货地址编号  
    @NotNull
    private Integer orderState; // 订单状态（0：未支付； 1：已支付）  
}
