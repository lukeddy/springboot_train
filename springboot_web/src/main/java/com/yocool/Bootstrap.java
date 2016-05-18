package com.yocool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yocool")
public class Bootstrap {
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}
}
