package com.atguigu.springcloud.service;

import com.atguigu.springcloud.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: null.java
 * @Package com.atguigu.springcloud.service
 * @Description: TODO
 * @date 2020/5/15 22:20
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    
    @RequestMapping( value = "/payment/get/{id}", method = RequestMethod.GET)
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @RequestMapping(value = "/payment/feign/timeout", method = RequestMethod.GET)
    String paymentFeignTimeout();
}
