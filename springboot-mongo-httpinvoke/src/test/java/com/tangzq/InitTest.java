package com.tangzq;

import com.tangzq.model.User;
import com.tangzq.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
@WebAppConfiguration
public class InitTest {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 注意：测试发现如果mongo数据库配置信息不在测试目录下配置，默认会将数据保存到test库中
	 */
	@Test
	public void initSomeUsers(){
		for(int i=0;i<10;i++){
			User user=new User();
			user.setFullname("强强哥"+i);
			user.setPhone("1366666666"+i);
			user.setCreatedAt(new Date());
			user.setUpdatedAt(new Date());
			userRepository.save(user);
		}
	}
}
