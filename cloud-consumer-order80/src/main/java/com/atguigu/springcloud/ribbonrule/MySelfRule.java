package com.atguigu.springcloud.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: null.java
 * @Package com.atguigu.springcloud.ribbonrule
 * @Description: ribbon自定义负载均衡配置不能放在@ComponentScan所扫描的当前包下及子包下，
 *               否则我们这个自定义的配置类就会被Ribbon客户端所共享，就达不到特殊化定制的目的了
 * @date 2020/4/12 22:33
 */
@Configuration
public class MySelfRule {

    /**
     * ribbon 负载均衡规则为随机
     * @return
     */
    @Bean
    public IRule myRule() {
        return new  RandomRule();
    }
}
