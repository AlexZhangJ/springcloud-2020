package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title:
 * @Package com.atguigu.springcloud.dao
 * @Description: TODO
 * @date 2020/4/4 17:16
 */
@Mapper
public interface PaymentDao {
    public Integer create(Payment payment);

    public Payment getPaymentById(Long id);
}
