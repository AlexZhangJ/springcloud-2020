package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: null.java
 * @Package com.atguigu.springcloud
 * @Description: TODO
 * @date 2020/5/16 22:52
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignOrder80.class, args);
    }
}
