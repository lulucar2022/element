package cn.lulucar.element.controller;

import cn.lulucar.element.entity.Business;
import cn.lulucar.element.entity.Food;
import cn.lulucar.element.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName FoodController
 * @date 2024/6/18 8:24
 * @description
 */
@Tag(name = "食品管理")
@RestController
@RequestMapping("/FoodController")
public class FoodController {
    @Resource
    private FoodService foodService;
    
    @Operation(summary = "根据商家id查询食品列表")
    @GetMapping("/listFoodByBusinessId")
    public List<Food> listFoodByBusinessId(Integer businessId){
        return foodService.listFoodByBusinessId(businessId);
    }
}
