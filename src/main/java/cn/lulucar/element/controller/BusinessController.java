package cn.lulucar.element.controller;

import cn.lulucar.element.entity.Business;
import cn.lulucar.element.service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName BussinessController
 * @date 2024/6/17 14:26
 * @description
 */
@Slf4j
@Tag(name = "商店管理")
@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
    @Resource
    private BusinessService businessService;
    @Operation(summary = "根据订单类型id获取商店信息")
    @GetMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId){
        return businessService.listBusinessByOrderTypeId(orderTypeId);
    }
    
    @Operation(summary = "根据商家id获取商店信息")
    @GetMapping("/getBusinessById")
    public Business getBusinessById(Integer businessId){
        return businessService.getBusinessById(businessId);
    }
}
