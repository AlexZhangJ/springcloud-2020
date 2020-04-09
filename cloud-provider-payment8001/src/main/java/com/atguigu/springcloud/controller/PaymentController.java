package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title:
 * @Package com.atguigu.springcloud.controller
 * @Description: TODO
 * @date 2020/4/4 18:14
 */
@RestController
@Slf4j
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;
    
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("add payment info, payment= [{}]", payment);
        
        int result =  paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入成功");
        }else {
            return new CommonResult(444, "插入失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("get payment info, id = [{}]", id);

        Payment result =  paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult(200, "查询成功", result);
        }else {
            return new CommonResult(444, "没有对应记录，查询ID:" + id);
        }
    }
}
