package cn.lulucar.element.controller;

import cn.lulucar.element.entity.Business;
import cn.lulucar.element.service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName BussinessController
 * @date 2024/6/17 14:26
 * @description
 */
@Tag(name = "商店管理")
@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
    @Resource
    private BusinessService businessService;
    @Operation(summary = "获取商店列表")
    @GetMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId){
        List<Business> businesses = businessService.listBusinessByOrderTypeId(orderTypeId);
        return businesses;
    }
    
    @Operation(summary = "根据id获取商店信息")
    @GetMapping("/getBusinessById")
    public Business getBusinessById(Integer businessId){
        return businessService.getBusinessById(businessId);
    }
}
