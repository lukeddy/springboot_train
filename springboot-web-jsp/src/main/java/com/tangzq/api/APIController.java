package com.tangzq.api;

import com.tangzq.api.response.Result;
import com.tangzq.model.Product;
import com.tangzq.service.ProductService;
import com.tangzq.util.VerifyCodeUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * REST API接口
 * Author tangzq.
 */

@ResponseBody
@RestController
@RequestMapping("/api/v1")
public class APIController {


    private static final String APT_TAG="测试接口";
    private static final String VERIFY_CODE_SESSION_ATTR = "WEBCENTER_LOGIN_VERIFY_CODE";

    @Value("${com.tangzq.config.verifyCodeLength}")
    private int verifyCodeLength;

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "产品列表", httpMethod = "GET", notes = "获取所有产品API！",tags = APT_TAG)
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


    @ApiOperation(value = "问候一下", httpMethod = "GET", notes = "这里只是做测试的API！",tags = APT_TAG)
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


    @RequestMapping(value = "/verifycode/{clientTime}.jpg", method = RequestMethod.GET)
    @ApiOperation(value = "生成验证码", httpMethod = "GET", notes = "生成验证码", tags = APT_TAG)
    public void verifyCode(HttpServletRequest request, HttpServletResponse response,
                           @ApiParam(required = true, name = "clientTime", value = "客户端的时间戳") @PathVariable("clientTime") Long clientTime)
            throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        String verifyCode = VerifyCodeUtils.generateVerifyCode(verifyCodeLength);
        HttpSession session = request.getSession();
        session.setAttribute(VERIFY_CODE_SESSION_ATTR, verifyCode.toLowerCase());
        VerifyCodeUtils.outputImage(50 * verifyCodeLength, 80, response.getOutputStream(),verifyCode);
    }

}
