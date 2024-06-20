package cn.lulucar.element.service;

import cn.lulucar.element.entity.DeliveryAddress;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName DeliveryAddressService
 * @date 2024/6/20 20:35
 * @description
 */
@Service
public interface DeliveryAddressService {
    /**
     * 获取指定用户的送货地址列表
     * @param userId 用户ID
     * @return 送货地址列表
     */
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
    /**
     * 根据ID获取送货地址
     * @param daId 送货地址ID
     * @return 送货地址
     */
    public DeliveryAddress getDeliveryAddressById(Integer daId);
    /**
     * 保存送货地址
     * @param deliveryAddress 要保存的送货地址
     * @return 送货地址ID
     */
    public Integer saveDeliveryAddress(DeliveryAddress deliveryAddress);
    /**
     * 更新送货地址
     * @param deliveryAddress 要更新的送货地址
     * @return 送货地址ID
     */
    public Integer updateDeliveryAddress(DeliveryAddress deliveryAddress);
    /**
     * 删除送货地址
     * @param daId 送货地址ID
     * @return 送货地址ID
     */
    public Integer removeDeliveryAddress(Integer daId);

}
