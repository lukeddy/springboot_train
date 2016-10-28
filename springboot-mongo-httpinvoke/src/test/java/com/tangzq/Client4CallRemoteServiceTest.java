package com.tangzq;

import com.tangzq.vo.UserInfoVo;
import com.tangzq.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
@WebAppConfiguration
public class Client4CallRemoteServiceTest {

	/**
	 * 记得启动服务哦
	 * @return
	 */
	private UserInfoService getUserServiceBean(){
		HttpInvokerProxyFactoryBean fb = new HttpInvokerProxyFactoryBean();
		fb.setServiceUrl("http://127.0.0.1:8888/my-app/"+UserInfoService.HTTP_INVOKER_EXPORT_CONTEXT);
		fb.setServiceInterface(UserInfoService.class);
		fb.afterPropertiesSet();
		return (UserInfoService) fb.getObject();
	}

	@Test
	public void testFindUserById() {
		UserInfoVo user=getUserServiceBean().findUserInfoById("5812fdc37db0abb974c68752");
		Assert.notNull(user);
		System.out.println(user);
	}

	@Test
	public void testFindUserByPhone(){
		UserInfoVo user=getUserServiceBean().findUserInfoByPhone("13666666662");
		Assert.notNull(user);
		System.out.println(user);
	}

	@Test
	public void testFindUserNameById(){
		String username=getUserServiceBean().findUserFullNameById("5812fdc37db0abb974c68752");
		Assert.notNull(username);
		System.out.println(username);
	}


	@Test
	public void testFindUserNameByPhone(){
		String username=getUserServiceBean().findUserFullNameByPhone("13666666666");
		Assert.notNull(username);
		System.out.println(username);
	}

}
