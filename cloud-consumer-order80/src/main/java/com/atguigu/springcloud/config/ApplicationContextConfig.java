package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: 上下文环境配置
 * @Package com.atguigu.springcloud.config
 * @Description: TODO
 * @date 2020/4/4 22:26
 */
@Configuration
public class ApplicationContextConfig {
    
    @Bean
    @LoadBalanced  //负载均衡
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }
}
