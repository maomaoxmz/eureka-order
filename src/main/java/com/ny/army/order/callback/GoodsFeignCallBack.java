package com.ny.army.order.callback;

import com.ny.army.order.feign.GoodsFeign;
import org.springframework.stereotype.Component;

// 熔断器类
@Component
public class GoodsFeignCallBack implements GoodsFeign {
    @Override
    public String select() {
        return "hystrix--服务器忙，请稍后再试!";
    }
}
