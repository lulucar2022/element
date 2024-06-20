package cn.lulucar.element.service.impl;

import cn.lulucar.element.entity.Cart;
import cn.lulucar.element.mapper.CartMapper;
import cn.lulucar.element.model.dto.CartDTO;
import cn.lulucar.element.service.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wenxiaolan
 * @ClassName CartServiceImplTest
 * @date 2024/6/19 16:32
 * @description
 */
@SpringBootTest
class CartServiceImplTest {

    @Autowired
    private CartService cartService;
    @Test
    void listCart() {
        Cart cart = new Cart();
        cart.setUserId("123123123");
        cart.setCartId(1);
        cart.setBusinessId(10001);
        cart.setFoodId(1);
        List<CartDTO> cartDTOS = cartService.listCart(cart.getUserId(), cart.getBusinessId());
        Assertions.assertNotNull(cartDTOS);
        System.out.println(cartDTOS);
    }
}