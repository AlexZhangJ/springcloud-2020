package com.atguigu.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangxiaolin
 * @version V1.0
 * @Title: rest 接口返回实体类
 * @Package com.atguigu.springcloud.common
 * @Description: TODO
 * @date 2020/4/4 17:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    
    private String msg;
    
    private T data;
    
    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
