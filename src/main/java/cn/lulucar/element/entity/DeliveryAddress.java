package cn.lulucar.element.entity;

import lombok.Data;

/**
 * @author wenxiaolan
 * @ClassName DeliveryAddress
 * @date 2024/6/17 14:36
 * @description
 */
@Data
public class DeliveryAddress {
    private Integer daId; // 送货地址编号，主键，自增  

    private String contactName; // 联系人姓名  

    private Integer contactSex; // 联系人性别  

    private String contactTel; // 联系人电话  

    private String address; // 送货地址  

    private String userId; // 所属用户编号  
}
