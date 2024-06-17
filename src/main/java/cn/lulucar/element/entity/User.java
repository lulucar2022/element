package cn.lulucar.element.entity;

import lombok.Data;

/**
 * @author wenxiaolan
 * @ClassName User
 * @date 2024/6/17 14:36
 * @description
 */
@Data
public class User {
    private String userId; // 用户编号，主键  

    private String password; // 密码  

    private String userName; // 用户名称  

    private Integer userSex; // 用户性别（1：男； 0：女）  

    private String userImg; // 用户头像（通常存储图片的路径或URL）  

    private Integer delTag; // 删除标记（1：正常； 0：删除） 
}
