package com.ny.army.order.feign;

import com.ny.army.order.callback.GoodsFeignCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "eureka-goods", fallback = GoodsFeignCallBack.class)
public interface GoodsFeign {

//    feign自带 负载均衡
    @GetMapping("/goods/selectList")
    String select();
}
