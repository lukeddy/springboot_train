package com.yocool;

import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.utils.UUIDs;
import com.yocool.dao.PersonPagerRepository;
import com.yocool.dao.PersonRepository;
import com.yocool.model.Person;
import com.yocool.utils.MyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.select;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootCassandraApplication.class)
@WebAppConfiguration
public class SpringbootCassandraApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CassandraTemplate cassandraTemplate;


	@Test
	public void initData(){
		for(int i=0;i<100;i++){
			personRepository.save(new Person(UUIDs.random().toString(),"用户名"+i,18+i));
		}
		System.out.printf("初始化数据完成！");
	}


	@Test
	public void testFindAll() {
		List<Person> personList=(ArrayList<Person>)personRepository.findAll();
		Assert.notNull(personList);
		for (Person person : personList) {
			System.out.println(person);
		}
	}

	@Test
	public void testFindByName(){
		Assert.notNull(personRepository.findOne("a132dc3d-db3d-4605-8f42-7d008cdadf3a"));
		Assert.isNull(personRepository.findOne("abc"));
	}

	@Test
	public void testUpdate(){
		String id="f37ae508-7dd4-4e73-8ff3-b57cb8ad47d6";
		Person person=new Person(id,"西西李",32);
		Person savedPerson=personRepository.save(person);
		Assert.notNull(savedPerson);
		Assert.notNull(personRepository.findOne(id));
	}

	@Test
	public void testDelete(){
		String id="4fe5c51c-721f-4f7c-8f3c-09e87e063578";
		personRepository.delete(id);
		Assert.isNull(personRepository.findOne(id));
	}


	@Test
	public void testPagination(){
		Select selectRecord = select()
				.from(MyUtils.getTableName(Person.class))
				.where(eq("name", "用户名89"))
				.and(eq("age", 107))
				.limit(10)
				.allowFiltering();

		List<Person> list= cassandraTemplate.select(selectRecord,Person.class);
		Assert.notNull(list);
		for(Person person:list){
			System.out.println(person.toString());
		}
	}
}
