package cn.lulucar.element.service;

import cn.lulucar.element.controller.FoodController;
import cn.lulucar.element.entity.Food;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName FoodService
 * @date 2024/6/18 8:26
 * @description
 */
@Service
public interface FoodService {
    List<Food> listFoodByBusinessId(Integer businessId);
}
