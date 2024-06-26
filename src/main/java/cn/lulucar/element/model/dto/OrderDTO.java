package cn.lulucar.element.model.dto;

import cn.lulucar.element.entity.Business;
import cn.lulucar.element.entity.Food;
import cn.lulucar.element.entity.OrderDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName OrderDTO
 * @date 2024/6/22 11:18
 * @description
 */
@Data
@Validated
public class OrderDTO {
    private Integer orderId; // 订单编号，主键，自增  
    @NotNull
    private String userId; // 用户编号  
    @NotNull
    private Integer businessId; // 商家编号  

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate; // 订购日期（通常建议使用日期类型如java.time.LocalDate）  
    @NotNull
    private BigDecimal orderTotal; // 订单总价  
    @NotNull
    private Integer daId; // 送货地址编号  
    @NotNull
    private Integer orderState; // 订单状态（0：未支付； 1：已支付）  
    
    private List<OrderDetailDTO> orderDetails; // 订单详情
    private Business business; // 商家信息
}
