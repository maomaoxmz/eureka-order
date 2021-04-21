package com.ny.army.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
public class InstanceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    // http://localhost:7003/services
    @GetMapping("/services")
    public Set<String> getServices() {
        return new LinkedHashSet<>(discoveryClient.getServices());
    }

    //http://localhost:7003/services/eureka
    @GetMapping("/services/{serviceName}")
    public List<ServiceInstance> getServiceInstances(@PathVariable String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }

    //http://localhost:7003/services/eureka/DESKTOP-2GK20C0:eureka:8081
    @GetMapping("/services/{serviceName}/{instanceId}")
    public ServiceInstance getServiceInstance(@PathVariable String serviceName, @PathVariable String instanceId) {
        return getServiceInstances(serviceName)
                .stream()
                .filter(serviceInstance -> instanceId.equals(serviceInstance.getInstanceId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No Such service instance"));
    }
}
