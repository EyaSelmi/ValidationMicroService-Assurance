package com.esprit.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AssuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceApplication.class, args);
	}

}
