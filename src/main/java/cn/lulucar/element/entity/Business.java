package cn.lulucar.element.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wenxiaolan
 * @ClassName Business
 * @date 2024/6/17 14:35
 * @description
 */
@Data
@Schema(title = "商家管理" ,description = "商家信息")
public class Business {
    /**
     * 商家id
     */
    @Schema(description = "商家id",name = "businessId")
    private Integer businessId;
    
    /**
     * 商家名称
     */
    @Schema(description = "商家名称",name = "businessName")
    private String businessName;

    /**
     * 商家地址
     */
    @Schema(description = "商家地址",name = "businessAddress")
    private String businessAddress;

    /**
     * 商家介绍
     */
    @Schema(description = "商家介绍",name = "businessExplain")
    private String businessExplain;

    /**
     * 商家图片（base64）
     */
    @Schema(description = "商家图片（base64）",name = "businessImg")
    private String businessImg;

    /**
     * 点餐分类
     */
    @Schema(description = "点餐分类",name = "orderTypeId")
    private Integer orderTypeId;

    /**
     * 起送费
     */
    @Schema(description = "起送费",name = "startPrice")
    private Double startPrice;

    /**
     * 配送费
     */
    @Schema(description = "配送费",name = "deliveryPrice")
    private Double deliveryPrice;

    /**
     * 备注
     */
    @Schema(description = "备注",name = "remarks")
    private String remarks;
}
