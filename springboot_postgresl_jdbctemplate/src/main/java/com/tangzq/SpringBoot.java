package com.tangzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tangzq"})
public class SpringBoot{
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);
	}
}
