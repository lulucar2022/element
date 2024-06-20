package cn.lulucar.element.service.impl;

import cn.lulucar.element.entity.User;
import cn.lulucar.element.mapper.UserMapper;
import cn.lulucar.element.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenxiaolan
 * @ClassName UserServiceImpl
 * @date 2024/6/19 9:14
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 根据用户id和密码查询用户
     * @param userId 用户id
     * @param password 密码
     * @return
     */
    @Override
    public User login(String userId, String password) {
        return userMapper.getUserByIdByPass(userId,password);
    }

    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    @Override
    public int checkUserId(String userId) {
        return userMapper.getUserById(userId);
    }

    /**
     * 保存用户
     * @param userId 用户id
     * @param password 密码
     * @param userName 用户名
     * @param userSex 性别
     * @return
     */
    @Override
    public int saveUser(String userId,String password,String userName,Integer userSex) {
        return userMapper.saveUser(userId,password,userName,userSex);
    }
}
