package cn.lulucar.element.mapper;

import cn.lulucar.element.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName OrderDetailMapper
 * @date 2024/6/22 10:21
 * @description
 */
public interface OrderDetailMapper {
    
    Integer insertOrderDetail(@Param("orderDetailList") List<OrderDetail> orderDetailList);

    List<OrderDetail> listOrderDetailByOrderId(Integer orderId);
}
