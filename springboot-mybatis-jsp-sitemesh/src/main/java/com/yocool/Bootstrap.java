package com.yocool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bootstrap {
	   public static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

	    public static void main(String[] args) {
	        SpringApplication.run(Bootstrap.class, args);
	        logger.info("启动成功!");
	    }
}
