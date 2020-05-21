package com.atguigu.springcloud.casandunsafe;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
