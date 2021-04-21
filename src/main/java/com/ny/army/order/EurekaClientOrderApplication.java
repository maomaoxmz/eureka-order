package com.ny.army.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Idea->Run/Debug Configuration->VM options:
// --Dspring.profiles.active=dev
// Idea->Run/Debug Configuration->Program arguments:
// --spring.profiles.active=dev
// 命令行激活指定环境配置:
//java -jar xxx.jar --spring.profiles.active=dev
@EnableHystrix
//@EnableEurekaClient
@EnableFeignClients(basePackages = "com.ny.army.order.feign")
@SpringBootApplication
public class EurekaClientOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientOrderApplication.class, args);
    }

}
