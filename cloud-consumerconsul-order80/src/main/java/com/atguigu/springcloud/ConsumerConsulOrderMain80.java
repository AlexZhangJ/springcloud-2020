package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: null.java
 * @Package com.atguigu.springcloud
 * @Description: TODO
 * @date 2020/4/12 18:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOrderMain80.class, args);
    }
}
