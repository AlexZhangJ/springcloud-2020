package com.atguigu.springcloud;

import com.atguigu.springcloud.ribbonrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title:
 * @Package com.atguigu.com
 * @Description: TODO
 * @date 2020/4/4 22:25
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = " CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class) //自定义ribbon负载均衡规则
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
