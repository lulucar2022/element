package cn.lulucar.element.model.dto;

import cn.lulucar.element.entity.Food;
import cn.lulucar.element.entity.OrderDetail;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

/**
 * @author wenxiaolan
 * @ClassName OrderDetailDTO
 * @date 2024/6/26 9:21
 * @description
 */
@Getter
public class OrderDetailDTO extends OrderDetail {
    
    private Food food;

    public void setFood(Food food) {
        this.food = food;
    }
}
