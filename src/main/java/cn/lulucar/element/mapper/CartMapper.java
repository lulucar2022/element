package cn.lulucar.element.mapper;

import cn.lulucar.element.entity.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName CartMapper
 * @date 2024/6/19 15:35
 * @description
 */
public interface CartMapper {
    public List<Cart> listCart(@Param("userId") String userId,@Param("businessId") Integer businessId);
    
    @Insert("insert into cart values(null,#{foodId},#{businessId},#{userId},1)")
    public int insertCart(@Param("foodId") Integer foodId, @Param("businessId") Integer businessId, @Param("userId") String userId);

    @Update("update cart set quantity=#{quantity} where foodId=#{foodId} and businessId = #{businessId} and userId=#{userId}")
    public int updateCart(@Param("foodId") Integer foodId, @Param("businessId") Integer businessId, @Param("userId") String userId, @Param("quantity") Integer quantity);

    public int deleteCart(@Param("foodId") Integer foodId, @Param("businessId") Integer businessId, @Param("userId") String userId);
}
