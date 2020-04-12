package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title:
 * @Package com.atguigu.springcloud.controller
 * @Description: TODO
 * @date 2020/4/4 18:14
 */
@RestController
@Slf4j
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;
    
    @Value("${server.port}")
    private String serverPort;
    
    //对于注册到eureka里面的微服务，可以通过服务发现来获得该服务的信息
    @Resource
    private DiscoveryClient discoveryClient;
    
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("add payment info, payment= [{}]", payment);
        
        int result =  paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入成功，" + serverPort);
        }else {
            return new CommonResult(444, "插入失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("get payment info, id = [{}]", id);

        Payment result =  paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult(200, "查询成功，" + serverPort, result);
        }else {
            return new CommonResult(444, "没有对应记录，查询ID:" + id, result);
        }
    }

    /**
     * 通过服务发现客户端 discoveryClient，获取注册到eureka的服务信息
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**********service, {}", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        
        return discoveryClient;
    }
}
