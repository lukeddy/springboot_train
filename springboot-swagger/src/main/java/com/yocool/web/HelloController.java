package com.yocool.web;

import com.wordnik.swagger.annotations.*;
import com.yocool.model.Greeting;
import com.yocool.model.UserBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value="/simple")
public class HelloController {

    private static final String template = "你好哦, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/hello")
    @ApiOperation(value = "问候接口",httpMethod ="POST", response = UserBean.class,notes = "这是个测试接口")
    public UserBean hello(@ApiParam(required = true,name = "paramData",value = "用户信息json数据") String paramData){
        UserBean userBean = new UserBean();
        userBean.setUsername("coolman");
        userBean.setPassword("123456");
        return userBean;
    }



    @ApiOperation(value = "问候接口2", httpMethod = "GET", response = Greeting.class,notes="问候一下")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功", response = Greeting.class),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求资源不存在"),
            @ApiResponse(code = 500, message = "服务器异常")})
    @RequestMapping(method = RequestMethod.GET, path="/greeting", produces = "application/json")
    public Greeting greeting(@RequestParam(value="name",required = true) String name) {

        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
}