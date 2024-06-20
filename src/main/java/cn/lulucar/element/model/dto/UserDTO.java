package cn.lulucar.element.model.dto;

import lombok.Data;

/**
 * @author wenxiaolan
 * @ClassName UserDTO
 * @date 2024/6/19 9:28
 * @description
 */
@Data
public class UserDTO {
    private String userId;
    private String password;
    private String userName;
    private Integer userSex;

}
