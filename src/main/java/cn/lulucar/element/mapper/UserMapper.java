package cn.lulucar.element.mapper;

import cn.lulucar.element.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wenxiaolan
 * @ClassName UserMapper
 * @date 2024/6/19 9:12
 * @description
 */
public interface UserMapper {
    @Select("select * from user where userId=#{userId} and password=#{password}")
    public User selectUserByIdByPass(@Param("userId") String userId, @Param("password") String password);
    @Select("select count(*) from user where userId=#{userId}")
    public int selectUserById(String userId);
    @Insert("insert into user values(#{userId},#{password},#{userName},#{userSex},null,1)")
    public int insertUser(String userId, String password, String userName, Integer userSex);
}
