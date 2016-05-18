package com.yocool;

import com.yocool.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yocool")
public class Bootstrap implements CommandLineRunner{

	@Autowired
	private BookService bookService;


	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("项目开始启动...開始初始化數據");
//		for(int i=0;i<100;i++){
//			bookService.createBook("Java入门"+i,"ISBN1313","王五"+i,100+i);
//		}

		System.out.println("初始换完成...");
	}
}
