package com.esprit.secondapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

}
