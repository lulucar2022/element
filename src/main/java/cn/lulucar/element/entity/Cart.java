package cn.lulucar.element.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author wenxiaolan
 * @ClassName Cart
 * @date 2024/6/17 14:35
 * @description
 */

@Data
@Schema(title = "购物车管理", description = "购物车信息")
public class Cart {
    @Schema(description = "购物车ID", name = "cartId")
    private Integer cartId; // 主键，自增  
    
    @Schema(description = "食品ID", name = "foodId")
    private Integer foodId;
    
    @Schema(description = "商家ID", name = "businessId")
    private Integer businessId;
    
    @Schema(description = "用户ID", name = "userId")
    private String userId;
    
    @Schema(description = "食品数量", name = "quantity")
    private Integer quantity;
    
    
}
