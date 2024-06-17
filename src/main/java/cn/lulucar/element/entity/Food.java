package cn.lulucar.element.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wenxiaolan
 * @ClassName Food
 * @date 2024/6/17 14:35
 * @description
 */
@Data
public class Food {
    private Integer foodId; // 食品编号，主键，自增  

    private String foodName; // 食品名称  

    private String foodExplain; // 食品介绍  

    private String foodImg; // 食品图片（通常这里存储的是图片的路径或URL，而不是图片本身）  

    private BigDecimal foodPrice; // 食品价格，使用BigDecimal以精确表示货币值  

    private Integer businessId; // 所属商家编号  

    private String remarks; // 备注  
}
