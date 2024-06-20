package cn.lulucar.element.controller;

import cn.lulucar.element.entity.DeliveryAddress;
import cn.lulucar.element.util.Result;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName DeliveryAddressController
 * @date 2024/6/20 16:52
 * @description
 */
@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
    @Operation(summary = "根据用户id查询收货地址")
    @GetMapping("/listDeliveryAddressByUserId")
    public Result<List<DeliveryAddress>> listDeliveryAddressByUserId(@RequestParam("userId") Integer userId){
        
        return null;
    }
    
    @Operation(summary = "根据收货地址id查询收货地址")
    @GetMapping("/getDeliveryAddressById")
    public Result<DeliveryAddress> getDeliveryAddressById(@RequestParam("daId") Integer daId){
        return null;
    }
    
    @Operation(summary = "添加送货地址")
    @PostMapping("/saveDeliveryAddress")
    public Result<Integer> saveDeliveryAddress( @RequestBody JSONObject jsonObject){
        return null;
    }
    
    @Operation(summary = "修改送货地址")
    @PostMapping("/updateDeliveryAddress")
    public Result<Integer> updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress){
        return null;
    }
    
    @Operation(summary = "删除送货地址")
    @PostMapping("/removeDeliveryAddressById")
    public Result<Integer> removeDeliveryAddressById(@RequestBody JSONObject jsonObject){
        return null;
    }
}
