package com.yocool.web;

import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * API控制器
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加用户操作，这里只是做测试，没有任何参数！")
    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public String addUser() {
        return "添加完成";
    }
    @ApiOperation(value = "删除用户", httpMethod = "POST", notes = "删除用户，这里只是做测试，没有任何参数！")
    @RequestMapping(path = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(required = true) Integer uid) {
        return "删除完成";
    }
    @ApiOperation(value = "修改用户", httpMethod = "POST", notes = "修改用户，这里只是做测试，没有任何参数！")
    @RequestMapping(path = "/updateUser", method = RequestMethod.POST)
    public String updateUser(
            @RequestParam(required = true) Integer uid,
            @RequestParam(required = true) String uname
    ) {
        return "修改完成";
    }
    @ApiOperation(value = "查找用户", httpMethod = "GET", notes = "查找用户，这里只是做测试，没有任何参数！")
    @RequestMapping(path = "/listUser", method = RequestMethod.GET)
    public String listUser() {
        return "查找完成";
    }
}
