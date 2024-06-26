package cn.lulucar.element.mapper;

import cn.lulucar.element.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName OrderMapper
 * @date 2024/6/22 8:45
 * @description
 */
public interface OrderMapper {

    @Insert("INSERT INTO orders (userId, businessId,orderDate, daId, orderTotal) VALUES (#{userId}, #{businessId},#{orderDate} , #{daId}, #{orderTotal})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    void insertOrder(Order order);

    @Select("SELECT * FROM orders WHERE orderId = #{orderId}")
    Order selectOrderById(@Param("orderId") Integer orderId);
    
    @Select("SELECT * FROM orders WHERE userId = #{userId}")
    List<Order> listOrderByUserId(@Param("userId") String userId); 
    
    @Update("UPDATE orders SET orderState = #{orderState} WHERE orderId = #{orderId}")
    Integer updateOrderState(@Param("orderId") Integer orderId, @Param("orderState") Integer orderState);
}
