package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: null.java
 * @Package com.atguigu.springcloud.controller
 * @Description: TODO
 * @date 2020/5/15 22:26
 */
@RestController
public class OrderController {
   
    @Autowired
    private PaymentFeignService paymentFeignService;
    
   @GetMapping("/consumer/payment/get/{id}")
   public CommonResult getPaymentById(@PathVariable("id") Long id) {
       return paymentFeignService.getPaymentById(id);
   }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() { 
        return paymentFeignService.paymentFeignTimeout();      
    }
}
