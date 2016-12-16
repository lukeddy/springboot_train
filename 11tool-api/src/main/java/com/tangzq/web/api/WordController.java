package com.tangzq.web;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.tangzq.resp.JSONResponse;
import com.tangzq.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字数统计器
 */
@ResponseBody
@RestController
@RequestMapping("/api/v1")
public class WordController {

    private static final Logger logger= LoggerFactory.getLogger(CounterService.class);

    @Autowired
    private CounterService counterService;


    /**
     * 字数统计API接口方法
     * @param content
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path="/countWord", produces = "application/json")
    public JSONResponse listData(@RequestParam(value="content") String content){

        JSONResponse json=new JSONResponse();
        try{

            json.setData(counterService.parse(content));
        }catch (Exception e){
            logger.error("出错了",e);
            json.setStatus(false);
            json.setMsg("服务器端出错了,请稍后再试!");
        }


        return json;

    }



}
