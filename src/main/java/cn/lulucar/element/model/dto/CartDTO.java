package cn.lulucar.element.model.dto;

import cn.lulucar.element.entity.Business;
import cn.lulucar.element.entity.Food;
import lombok.Data;

/**
 * @author wenxiaolan
 * @ClassName CartDTO
 * @date 2024/6/19 16:21
 * @description
 */
@Data
public class CartDTO {
    private Integer cartId;
    private String userId;
    private Integer foodId;
    private Integer businessId;
    private Integer quantity;
    //多对一：所属食品
    private Food food;
    //多对一：所属商家
    private Business business;
}
