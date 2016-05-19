package com.yocool;

import com.datastax.driver.core.utils.UUIDs;
import com.yocool.dao.PersonRepository;
import com.yocool.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yocool")
public class SpringbootCassandraApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCassandraApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("开始初始化数据.。。。");
//		this.personRepository.deleteAll();

		//添加
//		this.personRepository.save(new Person(UUIDs.random().toString(),"露西李",18));
//		this.personRepository.save(new Person(UUIDs.timeBased().toString(),"丽丽王",20));
//		this.personRepository.save(new Person(UUIDs.timeBased().toString(),"思妍李",26));
//		this.personRepository.save(new Person(UUIDs.timeBased().toString(),"晓晓",20));

		// 查询
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Person person : this.personRepository.findAll()) {
//			System.out.println(person);
//		}
//		System.out.println();

		//按照名字查询
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(this.personRepository.findByName("晓晓"));


		System.out.println("初始化数据完成。。。");
	}
}
