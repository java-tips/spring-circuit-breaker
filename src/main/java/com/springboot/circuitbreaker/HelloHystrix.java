package com.springboot.circuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Service;

@Service
public class HelloHystrix {

    @HystrixCommand(fallbackMethod = "defaultEmpty", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
    public String getHello() throws InterruptedException {
        Thread.sleep(3000);    
        return "Hello!!!";
    }

    private String defaultEmpty() {
        return "Hello Hystrix!!!";
    }

}