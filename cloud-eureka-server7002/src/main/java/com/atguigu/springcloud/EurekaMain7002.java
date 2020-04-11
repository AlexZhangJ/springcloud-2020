package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title:
 * @Package com.atguigu.springcloud
 * @Description: TODO
 * @date 2020/4/11 20:36
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
