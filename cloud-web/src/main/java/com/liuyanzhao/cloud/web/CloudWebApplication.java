package com.liuyanzhao.cloud.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.liuyanzhao.cloud")
public class CloudWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudWebApplication.class, args);
	}
}
