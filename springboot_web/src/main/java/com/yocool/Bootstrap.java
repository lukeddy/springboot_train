package com.yocool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.yocool")
public class Bootstrap {
	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(Bootstrap.class, args);

		System.out.println("看看Spring Boot提供了哪些been:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
