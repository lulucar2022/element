package cn.lulucar.element.mapper;

import cn.lulucar.element.entity.Food;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName FoodMapper
 * @date 2024/6/18 8:29
 * @description
 */
public interface FoodMapper {
    @Select("select * from food where businessId = #{businessId}")
    List<Food> selectFoodByBusinessId(Integer businessId);
    
    @Select("select * from food where foodId = #{foodId}")
    Food selectFoodByFoodId(Integer foodId);
}
