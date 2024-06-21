package cn.lulucar.element.controller;

import cn.lulucar.element.entity.Cart;
import cn.lulucar.element.model.dto.CartDTO;
import cn.lulucar.element.service.CartService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName CartController
 * @date 2024/6/19 16:15
 * @description
 */
@Validated
@Tag(name = "购物车管理")
@RestController
@RequestMapping("/CartController")
public class CartController {
    @Resource
    private CartService cartService;
    
    @Operation(summary = "根据用户id和商家id获取购物车")
    @GetMapping("/listCart")
    public List<CartDTO> listCart(@RequestParam("userId") @NotNull String userId,
                                  @RequestParam("businessId")   Integer businessId){
        return cartService.listCart(userId, businessId);
    }
    
    @Operation(summary = "添加菜品到购物车")
    @PostMapping("/saveCart")
    public Integer saveCart(@RequestBody  JSONObject jsonObject){
        String userId;
        Integer businessId;
        Integer foodId;
        // 校验 userId
        if (jsonObject.containsKey("userId")) {
            userId = jsonObject.getString("userId");
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("userId cannot be null or empty");
            }
        } else {
            throw new IllegalArgumentException("userId is required");
        }

        // 校验 businessId
        if (jsonObject.containsKey("businessId")) {
            businessId = jsonObject.getInteger("businessId");
            if (businessId == null || businessId < 0) {
                throw new IllegalArgumentException("businessId cannot be null or negative");
            }
        } else {
            throw new IllegalArgumentException("businessId is required");
        }

        // 校验 foodId
        if (jsonObject.containsKey("foodId")) {
            foodId = jsonObject.getInteger("foodId");
            if (foodId == null || foodId < 0) {
                throw new IllegalArgumentException("foodId cannot be null or negative");
            }
        } else {
            throw new IllegalArgumentException("foodId is required");
        }
        
        // 执行添加操作
        return cartService.saveCart(userId, businessId, foodId);
    }
    
    @Operation(summary = "更新购物车")
    @PostMapping("/updateCart")
    public Integer updateCart(@RequestBody  JSONObject jsonObject){
        String userId;
        Integer businessId;
        Integer foodId;
        Integer quantity;
        // 校验 userId
        if (jsonObject.containsKey("userId")) {
            userId = jsonObject.getString("userId");
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("userId cannot be null or empty");
            }
        } else {
            throw new IllegalArgumentException("userId is required");
        }

        // 校验 businessId
        if (jsonObject.containsKey("businessId")) {
            businessId = jsonObject.getInteger("businessId");
            if (businessId == null || businessId < 0) {
                throw new IllegalArgumentException("businessId cannot be null or negative");
            }
        } else {
            throw new IllegalArgumentException("businessId is required");
        }

        // 校验 foodId
        if (jsonObject.containsKey("foodId")) {
            foodId = jsonObject.getInteger("foodId");
            if (foodId == null || foodId < 0) 
                throw new IllegalArgumentException("foodId cannot be null or negative");
        } else {
               throw new IllegalArgumentException("foodId cannot be null or negative");
        }
        
        // 校验数量
        if (jsonObject.containsKey("quantity")) {
            quantity = jsonObject.getInteger("quantity");
            if (quantity == null || quantity <= 0)
                throw new IllegalArgumentException("quantity cannot be null or negative");
        } else {
            throw new IllegalArgumentException("quantity cannot be null or negative");
        }
        
        // 执行更新操作
        return cartService.updateCart(userId,businessId,foodId,quantity);
    }
    
    @Operation(summary = "删除购物车的菜品",description = "根据userId，businessId，foodId删除购物车中的某条记录，foodId可选，有就删除具体某条，没有就全删除")
    @PostMapping("/removeCart")
    
    public Integer removeCart(@RequestBody  JSONObject jsonObject) {
        
        String userId;
        Integer businessId;
        Integer foodId;
        // 校验 userId
        if (jsonObject.containsKey("userId")) {
            userId = jsonObject.getString("userId");
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("userId cannot be null or empty");
            }
        } else {
            throw new IllegalArgumentException("userId is required");
        }

        // 校验 businessId
        if (jsonObject.containsKey("businessId")) {
            businessId = jsonObject.getInteger("businessId");
            if (businessId == null || businessId < 0) {
                throw new IllegalArgumentException("businessId cannot be null or negative");
            }
        } else {
            throw new IllegalArgumentException("businessId is required");
        }

        // 校验 foodId
        if (jsonObject.containsKey("foodId")) {
            foodId = jsonObject.getInteger("foodId");
            if (foodId == null || foodId < 0) 
                throw new IllegalArgumentException("foodId cannot be null or negative");
        } else {
            throw new IllegalArgumentException("foodId is required");
        }
        
        
        // 执行删除操作
        return cartService.removeCart(userId,businessId,foodId);
    }
}
