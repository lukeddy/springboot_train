package com.luke;

import com.luke.config.JwtProperties;
import com.luke.entity.UserInfo;
import com.luke.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private JwtProperties jwtProperties;

    @Test
    public void jwtTest() throws Exception {
        //生成token
        String token = JwtUtils.generateToken(new UserInfo(123456,"John"),jwtProperties.getPrivateKey(), jwtProperties.getExpire());
        System.out.println("token: "+token);

        //解析token
        UserInfo userInfo=JwtUtils.getInfoFromToken(token,jwtProperties.getPublicKey());
        System.out.println("info:"+userInfo);
    }

}
