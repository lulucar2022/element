package cn.lulucar.element.mapper;

import cn.lulucar.element.entity.Business;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName BusinessMapper
 * @date 2024/6/17 15:51
 * @description
 */

public interface BusinessMapper {
    @Select("select * from business where orderTypeId = #{id}")
    List<Business> listByOrderTypeId(@Param("orderTypeId") Integer orderTypeId);
    
    @Select("select * from business where businessId = #{businessId}")
    Business selectByBusinessId(@Param("businessId") Integer businessId);
}
