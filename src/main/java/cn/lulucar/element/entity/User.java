package cn.lulucar.element.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author wenxiaolan
 * @ClassName User
 * @date 2024/6/17 14:36
 * @description
 */
@Data
@Schema(title= "用户管理",description = "用户信息")
public class User {
    @Schema(name = "userId",description = "用户编号，主键")
    private String userId; // 用户编号，主键  
    @Schema(name = "password",description = "用户密码")
    private String password; // 密码  
    
    @Schema(name = "userName",description = "用户名称")
    private String userName; // 用户名称  
    
    @Schema(name = "userSex",description = "用户性别（1：男； 0：女）")
    private Integer userSex; // 用户性别（1：男； 0：女）  
    
    @Schema(name = "userImg",description = "用户头像（通常存储图片的路径或URL）")
    private String userImg; // 用户头像（通常存储图片的路径或URL）  
    @Schema(name = "delTag",description = "删除标记（1：正常； 0：删除）")    
    private Integer delTag; // 删除标记（1：正常； 0：删除） 
}
