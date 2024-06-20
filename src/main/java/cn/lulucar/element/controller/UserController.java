package cn.lulucar.element.controller;

import cn.lulucar.element.entity.User;
import cn.lulucar.element.model.dto.UserDTO;
import cn.lulucar.element.service.UserService;
import cn.lulucar.element.util.CollectionUtils;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenxiaolan
 * @ClassName UserController
 * @date 2024/6/19 9:17
 * @description
 */
@Slf4j
@Tag(name = "用户管理")
@RestController
@RequestMapping("/UserController")
public class UserController {
    @Resource
    private UserService userService;
    
    @Operation(summary = "用户登录")
    @PostMapping("/getUserByIdByPass")
    public User login(@RequestBody JSONObject jsonObject) {
        
        // 用户名和密码不能为空
        if (ObjectUtils.isEmpty(jsonObject.get("userId")) || ObjectUtils.isEmpty(jsonObject.get("password"))) {
            return null;
        }
        String userId = (String) jsonObject.get("userId");
        String password = (String) jsonObject.get("password");
        return userService.login(userId,password);
    }
    
    @Operation(summary = "根据用户ID获取用户信息")
    @GetMapping("/getUserById")
    public Integer checkUserId(@RequestParam("userId") String userId) {
        log.info("userId:{}",userId);
        return userService.checkUserId(userId);
    }
    
    @Operation(summary = "新增用户")
    @PostMapping("/saveUser")
    public Integer saveUser(@RequestBody(required = true) UserDTO userDTO) {
        String userId = null;
        String password = null;
        String userName = null;
        Integer userSex = null;
        
        if (userDTO.getUserId() != null && !userDTO.getUserId().isEmpty()) {
            userId = userDTO.getUserId();
        }

        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            password = userDTO.getPassword();
        }

        if (userDTO.getUserName() != null && !userDTO.getUserName().isEmpty()) {
            userName = userDTO.getUserName();
        }

        if (userDTO.getUserSex() != null && CollectionUtils.isAnyIn(null, userDTO.getUserSex())) {
            userSex = userDTO.getUserSex();
        }
        
        if (userId == null || password == null || userName == null || userSex == null) {
            return -1;
        }
        return userService.saveUser(userId, password, userName, userSex);


    }
}
