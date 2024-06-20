package cn.lulucar.element.service.impl;

import cn.lulucar.element.entity.DeliveryAddress;
import cn.lulucar.element.mapper.DeliveryAddressMapper;
import cn.lulucar.element.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName DeliveryAddressServiceImpl
 * @date 2024/6/20 20:42
 * @description
 */
@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private final DeliveryAddressMapper deliveryAddressMapper;

    public DeliveryAddressServiceImpl(DeliveryAddressMapper deliveryAddressMapper) {
        this.deliveryAddressMapper = deliveryAddressMapper;
    }


    /**
     * 获取指定用户的送货地址列表
     *
     * @param userId 用户ID
     * @return 送货地址列表
     */
    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
    }

    /**
     * 根据ID获取送货地址
     *
     * @param daId 送货地址ID
     * @return 送货地址
     */
    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return deliveryAddressMapper.getDeliveryAddressById(daId);
    }

    /**
     * 保存送货地址
     *
     * @param deliveryAddress 要保存的送货地址
     * @return 送货地址ID
     */
    @Override
    public Integer saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.saveDeliveryAddress(deliveryAddress.getContactName(), 
                deliveryAddress.getContactSex(),
                deliveryAddress.getContactTel(),
                deliveryAddress.getAddress(),
                deliveryAddress.getUserId());
    }

    /**
     * 更新送货地址
     *
     * @param deliveryAddress 要更新的送货地址
     * @return 送货地址ID
     */
    @Override
    public Integer updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        return null;
    }

    /**
     * 删除送货地址
     *
     * @param daId 送货地址ID
     * @return 送货地址ID
     */
    @Override
    public Integer removeDeliveryAddress(Integer daId) {
        return null;
    }
}
