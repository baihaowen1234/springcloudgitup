package com.atguigu.springcloud.casandunsafe;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
//        默认值 0
        int current;
//        访问次数
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2100000 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
//                                              //  期望的值 改变的值 valueOffset：内存偏移地址
                                                // CAS 对比如果改对象    atomicInteger 的值和期望的值相同改变后面的值
        return next;
    }





    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
//        索引下标
         int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
