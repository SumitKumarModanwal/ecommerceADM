package com.cts.deptboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptbootApplication.class, args);
		System.out.println("Hi from department spring boot");
	}

}
