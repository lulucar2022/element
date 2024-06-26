package cn.lulucar.element.mapper;

import cn.lulucar.element.entity.DeliveryAddress;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName DeliveryAddressMapper
 * @date 2024/6/20 20:32
 * @description
 */
public interface DeliveryAddressMapper {
    @Select("select * from deliveryAddress where userId=#{userId} order by daId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);

    @Select("select * from deliveryAddress where daId=#{daId}")
    public DeliveryAddress selectDeliveryAddressById(Integer daId);

    @Insert("insert into deliveryAddress values(null,#{contactName},#{contactSex},#{contactTel},#{address},#{userId})")
    public Integer insertDeliveryAddress(@Param("contactName") String contactName,
                                         @Param("contactSex") Integer contactSex,
                                         @Param("contactTel") String contactTel,
                                         @Param("address") String address,
                                         @Param("userId") String userId);

    @Update("update deliveryAddress set contactName=#{contactName},contactSex=#{contactSex},contactTel=#{contactTel},address=#{address} where daId=#{daId}")
    public Integer updateDeliveryAddress(@Param("contactName") String contactName,
                                         @Param("contactSex") Integer contactSex,
                                         @Param("contactTel") String contactTel,
                                         @Param("address") String address,
                                         @Param("daId") Integer daId);

    @Delete("delete from deliveryAddress where daId=#{daId}")
    public Integer deleteDeliveryAddress(Integer daId);

}
