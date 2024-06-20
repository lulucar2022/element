package cn.lulucar.element.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wenxiaolan
 * @ClassName Food
 * @date 2024/6/17 14:35
 * @description
 */
@Data
@Schema(title = "食品管理",description = "食品信息")
public class Food {
    @Schema(name = "fooId",description = "食品编号，主键，自增")
    private Integer foodId; // 食品编号，主键，自增  
    
    @Schema(name = "foodName",description = "食品名称")
    private String foodName; // 食品名称  
    
    @Schema(name = "foodExplain",description = "食品介绍")
    private String foodExplain; // 食品介绍  
    
    @Schema(name = "foodImg",description = "食品图片")
    private String foodImg; // 食品图片（通常这里存储的是图片的路径或URL，而不是图片本身）  
    
    @Schema(name = "foodPrice",description = "食品价格")
    private BigDecimal foodPrice; // 食品价格，使用BigDecimal以精确表示货币值  
    
    @Schema(name = "businessId",description = "所属商家编号")
    private Integer businessId; // 所属商家编号  
    
    @Schema(name = "remarks",description = "备注")
    private String remarks; // 备注  
}
