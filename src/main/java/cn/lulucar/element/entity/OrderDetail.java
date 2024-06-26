package cn.lulucar.element.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author wenxiaolan
 * @ClassName OrderDetail
 * @date 2024/6/22 8:53
 * @description
 */
@Data
@Schema(title = "订单详细实体类",description = "订单明细")
public class OrderDetail {

    @Schema(description = "订单明细编号")
    private Integer odId;

    @Schema(description = "所属订单编号")
    private Integer orderId;

    @Schema(description = "食品编号")
    private Integer foodId;

    @Schema(description = "数量")
    private Integer quantity;

}
