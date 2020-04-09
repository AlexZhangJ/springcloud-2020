package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: 支付流水表
 * @Package com.atguigu.springcloud.entities
 * @Description: TODO
 * @date 2020/4/4 17:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable{
    private Long id;
    
    private String serial;
    
}
