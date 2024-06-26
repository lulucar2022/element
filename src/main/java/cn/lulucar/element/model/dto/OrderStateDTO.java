package cn.lulucar.element.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * @author wenxiaolan
 * @ClassName OrderStateDTO
 * @date 2024/6/26 10:52
 * @description
 */
@Data
@Validated
public class OrderStateDTO {
    @NotNull
    private Integer orderId;
    @NotNull
    private Integer orderState;
}
