package cn.lulucar.element.service;

import cn.lulucar.element.entity.Business;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName BusinessService
 * @date 2024/6/17 15:50
 * @description
 */
@Service
public interface BusinessService {
    List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    
    Business getBusinessById(Integer businessId);
}
