package com.yocool.test;

import com.yocool.rpc.api.entity.User;
import com.yocool.rpc.api.service.HelloService;
import com.yocool.rpc.api.service.UserService;
import com.yocool.rpc.client.Bootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class ApplicationTests {

	private static final Logger logger= org.slf4j.LoggerFactory.getLogger(ApplicationTests.class);

	@Autowired
	private HelloService demoService;

	@Autowired
	private UserService userService;

	@Test
	public void testDemoService() {
		String r = demoService.sendMsg("你好！");
		logger.info(r);
	}

	@Test
	public void testUserService(){
		//发送到服务端
		String result = userService.test("我来自客户端");
		logger.info(result);

		//添加用户
		for(int i=0; i<100; i++) {
			String name = "用户"+i;
			User user = userService.createUser(name, i);
			logger.info("成功成功：" + user);
		}

		//取得所有用户
		List<User> users = userService.listUsers();
		logger.info(users.toString());
	}

}