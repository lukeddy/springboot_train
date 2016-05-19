package com.yocool.web;


import com.yocool.model.Greeting;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "当前值, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "问候", httpMethod = "GET", notes = "这里只是做测试的API！")
    @RequestMapping(method = RequestMethod.GET, path="/greeting", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = false, dataType = "string", paramType = "query", defaultValue="如,小王")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Greeting.class),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "找不到资源"),
            @ApiResponse(code = 500, message = "服务端异常")})
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}