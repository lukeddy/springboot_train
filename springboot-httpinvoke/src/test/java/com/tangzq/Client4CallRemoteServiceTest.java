package com.tangzq;

import com.tangzq.config.Config4Test;
import com.tangzq.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
@WebAppConfiguration
public class Client4CallRemoteServiceTest {

	@Autowired
	private Config4Test config4Test;

	private MyService getMyServiceBean(){
		HttpInvokerProxyFactoryBean fb = new HttpInvokerProxyFactoryBean();
		fb.setServiceUrl(config4Test.getRemoteEndPoint());
		fb.setServiceInterface(MyService.class);
		fb.afterPropertiesSet();
		return (MyService) fb.getObject();
	}

	@Test
	public void testGetMsg() {
		System.out.println(getMyServiceBean().getMsg("小小强"));
	}

	@Test
	public void testAdd(){
		System.out.println(getMyServiceBean().add(666,321));
	}

}
