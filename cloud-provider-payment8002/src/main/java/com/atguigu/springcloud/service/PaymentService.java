package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title:
 * @Package com.atguigu.springcloud.service
 * @Description: TODO
 * @date 2020/4/4 17:17
 */
public interface PaymentService {
    public Integer create(Payment payment);
    
    public Payment getPaymentById(Long id);
}
