package com.springboot.circuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class Application {

	@Autowired
	HelloHystrix helloHystrix;

	@RequestMapping("/hello")
    public String home() throws InterruptedException {
        return helloHystrix.getHello();
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
