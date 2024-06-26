package cn.lulucar.element.model.dto;

import cn.lulucar.element.entity.Business;
import cn.lulucar.element.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName Order4FoodDTO
 * @date 2024/6/26 10:12
 * @description
 */
@Getter
@Setter
public class Order4FoodDTO extends Order {
    private List<OrderDetailDTO> orderDetails;
    private Business business;
}
