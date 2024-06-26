package cn.lulucar.element.service;

import cn.lulucar.element.model.dto.OrderDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName OrderDetailService
 * @date 2024/6/26 9:20
 * @description
 */
@Service
public interface OrderDetailService {
    List<OrderDetailDTO> getOrderDetailList(Integer orderId);
}
