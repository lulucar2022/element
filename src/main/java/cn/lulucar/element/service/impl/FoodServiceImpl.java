package cn.lulucar.element.service.impl;

import cn.lulucar.element.entity.Food;
import cn.lulucar.element.mapper.FoodMapper;
import cn.lulucar.element.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName FoodServiceImpl
 * @date 2024/6/18 8:29
 * @description
 */
@Service
public class FoodServiceImpl implements FoodService {
    private final FoodMapper foodMapper;

    public FoodServiceImpl(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodMapper.selectFoodByBusinessId(businessId);
    }

    @Override
    public Food getFoodById(Integer foodId) {
        return foodMapper.selectFoodByFoodId(foodId);
    }
}
