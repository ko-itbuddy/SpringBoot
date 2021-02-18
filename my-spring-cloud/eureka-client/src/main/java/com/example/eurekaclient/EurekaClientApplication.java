package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class EurekaClientApplication {


	@Value("${spring.application.name}")
	private String appName;

	@GetMapping("/")
	public String home(){
		return "Hello world";
	}



	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}
