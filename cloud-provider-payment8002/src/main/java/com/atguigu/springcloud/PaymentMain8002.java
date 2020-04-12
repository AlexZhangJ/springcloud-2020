package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
@EnableDiscoveryClient //@EnableDiscoveryClient 对于注册到eureka里面的微服务，可以通过服务发现来获得该服务的信息
public class PaymentMain8002 {
    
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
