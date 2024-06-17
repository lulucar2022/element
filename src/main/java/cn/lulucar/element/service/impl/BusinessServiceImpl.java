package cn.lulucar.element.service.impl;

import cn.lulucar.element.entity.Business;
import cn.lulucar.element.mapper.BusinessMapper;
import cn.lulucar.element.service.BusinessService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName BusinessServiceImpl
 * @date 2024/6/17 16:03
 * @description
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    private final BusinessMapper businessMapper;

    public BusinessServiceImpl(BusinessMapper businessMapper) {
        this.businessMapper = businessMapper;
    }

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessMapper.listByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return businessMapper.selectByBusinessId(businessId);
    }
}
