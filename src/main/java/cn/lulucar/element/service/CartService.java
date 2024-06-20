package cn.lulucar.element.service;

import cn.lulucar.element.entity.Cart;
import cn.lulucar.element.model.dto.CartDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName CartService
 * @date 2024/6/19 16:06
 * @description
 */
@Service
public interface CartService {
    
    public List<CartDTO> listCart(String userId, Integer businessId);
    public int saveCart(String userId, Integer businessId, Integer foodId );
    public int updateCart(String userId, Integer businessId, Integer foodId, Integer quantity);
    public int removeCart(String userId, Integer businessId, Integer foodId);
}
