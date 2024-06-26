package cn.lulucar.element.controller;

import cn.lulucar.element.entity.DeliveryAddress;
import cn.lulucar.element.service.DeliveryAddressService;
import cn.lulucar.element.util.CollectionUtils;
import cn.lulucar.element.model.vo.Result;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName DeliveryAddressController
 * @date 2024/6/20 16:52
 * @description
 */
@Slf4j
@Tag(name = "收货地址管理")
@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
    @Resource
    private DeliveryAddressService deliveryAddressService;

    @Operation(summary = "根据用户id查询收货地址")
    @GetMapping("/listDeliveryAddressByUserId")
    public Result<List<DeliveryAddress>> listDeliveryAddressByUserId(@RequestParam("userId") String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("userId cannot be null or empty");
        }
        List<DeliveryAddress> deliveryAddressList = deliveryAddressService.listDeliveryAddressByUserId(userId);
        return Result.<List<DeliveryAddress>>builder().data(deliveryAddressList).build();
    }

    @Operation(summary = "根据收货地址id查询收货地址")
    @GetMapping("/getDeliveryAddressById")
    public Result<DeliveryAddress> getDeliveryAddressById(@RequestParam("daId") Integer daId) {
        if (daId == null || daId < 1) {
            throw new IllegalArgumentException("userId cannot be null or empty");
        }
        DeliveryAddress deliveryAddress = deliveryAddressService.getDeliveryAddressById(daId);
        return Result.<DeliveryAddress>builder().data(deliveryAddress).build();
    }

    @Operation(summary = "添加送货地址")
    @PostMapping("/saveDeliveryAddress")
    
    public Result<Integer> saveDeliveryAddress(@RequestBody  JSONObject jsonObject) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        if (jsonObject.get("address") == null || jsonObject.get("address").toString().isEmpty()) {
            throw new IllegalArgumentException("address cannot be null or empty");
        }
        if (jsonObject.get("contactSex") == null || !CollectionUtils.isAnyIn(null, jsonObject.getInteger("contactSex")))
            throw new IllegalArgumentException("contactSex cannot be null or empty");
        if (jsonObject.get("contactName") == null || jsonObject.get("contactName").toString().isEmpty())
            throw new IllegalArgumentException("contactName cannot be null or empty");

        if (jsonObject.get("userId") == null || jsonObject.get("userId").toString().isEmpty())
            throw new IllegalArgumentException("userId cannot be null or empty");

        if (jsonObject.get("contactTel") == null || jsonObject.get("contactTel").toString().isEmpty())
            throw new IllegalArgumentException("contactTel cannot be null or empty");
        deliveryAddress.setAddress((String) jsonObject.get("address"));
        deliveryAddress.setContactSex(jsonObject.getInteger("contactSex"));
        deliveryAddress.setContactName((String) jsonObject.get("contactName"));
        deliveryAddress.setUserId((String) jsonObject.get("userId"));
        deliveryAddress.setContactTel((String) jsonObject.get("contactTel"));

        Integer saved = deliveryAddressService.saveDeliveryAddress(deliveryAddress);
        return Result.<Integer>builder().data(saved).build();

    }

        @Operation(summary = "修改送货地址")
        @PostMapping("/updateDeliveryAddress")
        public Result<Integer> updateDeliveryAddress(@RequestBody JSONObject jsonObject) {
            DeliveryAddress deliveryAddress = new DeliveryAddress();
    
            if (jsonObject.get("daId") == null || jsonObject.getInteger("daId") <= 0)
                throw new IllegalArgumentException("daId cannot be null or negative");
            if (jsonObject.get("address") == null || jsonObject.getString("address").isEmpty())
                throw new IllegalArgumentException("address cannot be null or empty");
            if (jsonObject.get("contactSex") == null || !CollectionUtils.isAnyIn(null, jsonObject.getInteger("contactSex")))
                throw new IllegalArgumentException("contactSex cannot be null or empty");
            if (jsonObject.get("contactName") == null || jsonObject.get("contactName").toString().isEmpty())
                throw new IllegalArgumentException("contactName cannot be null or empty");
            if (jsonObject.get("contactTel") == null || jsonObject.get("contactTel").toString().isEmpty())
                throw new IllegalArgumentException("contactTel cannot be null or empty");
            
            deliveryAddress.setDaId(jsonObject.getInteger("daId"));
            deliveryAddress.setContactTel(jsonObject.getString("contactTel"));
            deliveryAddress.setAddress(jsonObject.getString("address"));
            deliveryAddress.setContactName(jsonObject.getString("contactName"));
            deliveryAddress.setContactSex(jsonObject.getInteger("contactSex"));
            Integer updated = deliveryAddressService.updateDeliveryAddress(deliveryAddress);
            return Result.<Integer>builder().data(updated).build();
        }

        @Operation(summary = "删除送货地址")
        @PostMapping("/removeDeliveryAddressById")
        public Result<Integer> removeDeliveryAddressById (@RequestBody JSONObject jsonObject){
            if (jsonObject.get("daId") == null || jsonObject.get("daId").toString().isEmpty()) 
                throw new IllegalArgumentException("daId cannot be null or empty");
            
            Integer removed = deliveryAddressService.removeDeliveryAddress((Integer) jsonObject.get("daId"));
            return Result.<Integer>builder()
                    .data(removed)
                    .build();
        }
    }
