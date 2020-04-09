package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: 主启动类
 * @Package com.atguigu.springcloud
 * @Description: TODO
 * @date 2020/4/4 15:47
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {
    
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
