package com.yocool;

import com.datastax.driver.core.utils.UUIDs;
import com.yocool.dao.PersonPagerRepository;
import com.yocool.dao.PersonRepository;
import com.yocool.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootCassandraApplication.class)
@WebAppConfiguration
public class SpringbootCassandraApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonPagerRepository personPagerRepository;

	@Test
	public void initData(){
		for(int i=0;i<100;i++){
			this.personRepository.save(new Person(UUIDs.random().toString(),"用户名"+i,18+i));
		}
		System.out.printf("初始化数据完成！");
	}


	@Test
	public void testFindAll() {
		// 查询
		for (Person person : this.personRepository.findAll()) {
			System.out.println(person);
		}
	}

	@Test
	public void testFindByName(){
		//按照名字查询
		System.out.println(this.personRepository.findByName("晓晓"));
	}

	@Test
	public void testUpdate(){
		Person person=new Person("6259fe70-1d6b-11e6-ac56-aba64e8c1447","西西李",32);
		personRepository.save(person);
		System.out.println(personRepository.findOne("6259fe70-1d6b-11e6-ac56-aba64e8c1447"));
	}

	@Test
	public void testDelete(){
		personRepository.delete("6259fe70-1d6b-11e6-ac56-aba64e8c1447");
		Assert.isNull(personRepository.findOne("6259fe70-1d6b-11e6-ac56-aba64e8c1447"));
	}

	@Test
	public void testPagination(){
		Page<Person> users = personPagerRepository.findAll(new QPageRequest(1, 2));
	}
}
