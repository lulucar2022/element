package cn.lulucar.element.service;

import cn.lulucar.element.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author wenxiaolan
 * @ClassName UserService
 * @date 2024/6/19 9:13
 * @description
 */
@Service
public interface UserService {
    User login(String userId, String password);
    int checkUserId(String userId);
    int saveUser(String userId,String password,String userName,Integer userSex);
}
