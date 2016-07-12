package com.tangzq;

import com.tangzq.model.Customer;
import com.tangzq.service.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBoot.class)
@WebAppConfiguration
public class ApplicationTests {

	@Autowired
	private CustomerDao customerDao;

	@Test
	public void testAddCustomer() {
		Customer customer=new Customer("张","三");
		customerDao.insert(customer);
	}

	@Test
	public void testFindAll(){
		List<Customer>  customerList=customerDao.findAll();
		Assert.notNull(customerList);
		for(Customer cus:customerList){
			System.out.println(cus.toString());
		}
	}

	@Test
	public void testUpdate(){
		Customer customer=new Customer(1,"AAA","bBB");
		customerDao.update(customer);
	}

	@Test
	public void testDelete(){
		customerDao.delete(3);
	}
}
