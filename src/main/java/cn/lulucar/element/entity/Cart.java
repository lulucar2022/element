package cn.lulucar.element.entity;

import lombok.Data;

/**
 * @author wenxiaolan
 * @ClassName Cart
 * @date 2024/6/17 14:35
 * @description
 */
@Data
public class Cart {
    private final Integer cartId; // 主键，自增  

    private Integer foodId;

    private Integer businessId;

    private String userId;

    private Integer quantity;
}
