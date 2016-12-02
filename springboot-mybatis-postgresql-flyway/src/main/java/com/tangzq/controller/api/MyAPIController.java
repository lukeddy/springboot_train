package com.tangzq.controller.api;

import com.tangzq.model.User;
import com.tangzq.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API接口
 * Author tangzq.
 */

@ResponseBody
@RestController
@RequestMapping("/api/v1")
public class MyAPIController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户列表", httpMethod = "GET", notes = "获取所有用户 信息！")
    @RequestMapping(method = RequestMethod.GET, value="/userList", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "找不到资源"),
            @ApiResponse(code = 500, message = "服务端异常")})
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @ApiOperation(value = "获取指定用户", httpMethod = "GET", notes = "获取指定用户 信息！")
    @RequestMapping(method = RequestMethod.GET, value="/user", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = false, dataType = "integer", paramType = "query", defaultValue="10100")
    })
    public User getUser(int id){
        return userService.getUser(id);
    }

    @ApiOperation(value = "问候一下", httpMethod = "GET", notes = "这里只是做测试的API！")
    @RequestMapping(method = RequestMethod.GET, value="/greeting", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = false, dataType = "string", paramType = "query", defaultValue="如,小王")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "找不到资源"),
            @ApiResponse(code = 500, message = "服务端异常")})
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "你好，"+name+",服务端反悔了消息";
    }


}
