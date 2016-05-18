package com.yocool;

import com.yocool.model.Customer;
import com.yocool.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动入口类
 */
@SpringBootApplication(scanBasePackages = "com.yocool")
@EnableAutoConfiguration
public class SpringbootMongoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoApplication.class, args);
	}

	/**
	 * 通过实现CommandLineRunner接口，在应用启动时调用
	 * @param strings
	 * @throws Exception
     */
	@Override
	public void run(String... strings) throws Exception {
		customerRepository.deleteAll();

		//添加内容
		customerRepository.save(new Customer("小五", "王"));
		customerRepository.save(new Customer("大大", "张"));
		customerRepository.save(new Customer("小夏", "李"));
		customerRepository.save(new Customer("天天", "李"));

		//查询所有内容
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		//根据firstName查询内容
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findByFirstName("小五"));

		//根据lastName查询
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByLastName("李")) {
			System.out.println(customer);
		}
		//TODO 更新
	}
}
