package com.ny.army.order.controller;

import com.ny.army.order.feign.GoodsFeign;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private GoodsFeign goodsFeign;

    // http://localhost:7003/order/selectList
    @GetMapping("/selectList")
    public String select() {
        return "订单下的商品列表---> " +goodsFeign.select();
    }

}
