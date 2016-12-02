package com.tangzq.test;

import com.tangzq.Bootstrap;
import com.tangzq.model.User;
import com.tangzq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Bootstrap.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser(){
        User user=new User(15,"王五",122,"mypwd");
        int result=userService.addUser(user);
        Assert.isTrue(result>0);
    }
}
