package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: null.java
 * @Package com.atguigu.springcloud.service
 * @Description: TODO
 * @date 2020/5/16 22:46
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_OK,id:" + id + " 正常访问！";
    }

    /**
     * 设置自身超时时间的峰值，超过这时间调用兜底方法，做服务降级fallback, 超时时间3秒
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 4;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_Timeout,id:" + id + " 耗时(秒):" + timeNumber;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "调用支付接口超时或者运行异常，线程池： " + Thread.currentThread().getName();
    }
    
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //断路器是否开启
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求总数阈值(10秒钟内超过10次)
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //快照时间窗口（统计时间请求成功数时间范围）
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //错误百分比阈值（10秒内超过60%失败）
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw new RuntimeException("id不能为负数");
        }
        
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber; 
    }
    
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id不能为负数，调用失败o(╥﹏╥)o，id=" + id;
    }
}
