package com.yocool.controller.api;

import com.yocool.controller.api.response.Result;
import com.yocool.model.Product;
import com.yocool.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST API接口
 * Author tangzq.
 */

@ResponseBody
@RestController
@RequestMapping("/api/v1")
public class MyAPIController {

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "产品列表", httpMethod = "GET", notes = "获取所有产品API！",tags = "接口1")
    @RequestMapping(method = RequestMethod.GET, path="/list", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "找不到资源"),
            @ApiResponse(code = 500, message = "服务端异常")})
    public ResponseEntity<Result<List<Product>>> listData(){
        return Result.success(productService.getAllProd(),"取得产品列表成功!");
    }


    @ApiOperation(value = "问候一下", httpMethod = "GET", notes = "这里只是做测试的API！",tags = "接口2")
    @RequestMapping(method = RequestMethod.GET, path="/greeting", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = false, dataType = "string", paramType = "query", defaultValue="如,小王")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "找不到资源"),
            @ApiResponse(code = 500, message = "服务端异常")})
    public ResponseEntity<Result<String>> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return Result.success("你好，"+name,"服务端反悔了消息");
    }


}
