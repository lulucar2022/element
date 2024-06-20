package cn.lulucar.element.service.impl;

import cn.lulucar.element.entity.Business;
import cn.lulucar.element.entity.Cart;
import cn.lulucar.element.entity.Food;
import cn.lulucar.element.mapper.BusinessMapper;
import cn.lulucar.element.mapper.CartMapper;
import cn.lulucar.element.mapper.FoodMapper;
import cn.lulucar.element.model.dto.CartDTO;
import cn.lulucar.element.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName CartServiceImpl
 * @date 2024/6/19 19:58
 * @description
 */
@Service
public class CartServiceImpl implements CartService {
    private final CartMapper cartMapper;
    private final BusinessMapper businessMapper;
    
    private final FoodMapper foodMapper;
    public CartServiceImpl(CartMapper cartMapper, BusinessMapper businessMapper, FoodMapper foodMapper) {
        this.cartMapper = cartMapper;
        this.businessMapper = businessMapper;
        this.foodMapper = foodMapper;
    }

    /**
     * 查询购物车
     * 需要同时返回 购物车中food和business
     * @param userId 用户id
     * @param businessId 商家id
     * @return
     */
    @Override
    public List<CartDTO> listCart(String userId, Integer businessId) {
        List<Cart> carts = cartMapper.listCart(userId, businessId);
        List<CartDTO> cartDTOS = new ArrayList<>();
        for (Cart cart : carts) {
            // 处理购物车数据
            Food food = foodMapper.selectFoodByFoodId(cart.getFoodId());
            Business business = businessMapper.selectByBusinessId(cart.getBusinessId());
            CartDTO cartDTO = new CartDTO();
            cartDTO.setFood(food);
            cartDTO.setBusiness(business);
            cartDTO.setBusinessId(cart.getBusinessId());
            cartDTO.setFoodId(cart.getFoodId());
            cartDTO.setUserId(cart.getUserId());
            cartDTO.setCartId(cart.getCartId());
            cartDTO.setQuantity(cart.getQuantity());
            cartDTOS.add(cartDTO);
        }
        return cartDTOS;
    }

    @Override
    public int saveCart(String userId, Integer businessId, Integer foodId) {
        return cartMapper.saveCart(foodId, businessId, userId);
    }

    @Override
    public int updateCart(String userId, Integer businessId, Integer foodId, Integer quantity) {
        return cartMapper.updateCart(foodId, businessId, userId, quantity);
    }

    @Override
    public int removeCart(String userId, Integer businessId, Integer foodId) {
        return cartMapper.removeCart(foodId, businessId, userId);
    }
}
