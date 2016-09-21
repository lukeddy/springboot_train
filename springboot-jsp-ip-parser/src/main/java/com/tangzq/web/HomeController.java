package com.tangzq.web;

import com.tangzq.service.IPService;
import com.tangzq.service.impl.IPServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author tangzq.
 */
@Controller
public class HomeController {

    private static final Logger logger= LoggerFactory.getLogger(IPServiceImpl.class);


    @Autowired
    private IPService ipService;

    /**
     * 网站首页
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String listData(){
        return "index";
    }

    /**
     * 查询IP归属地
     * @param ipList
     * @param model
     * @return
     */
    @PostMapping("/query")
    public String queryIPInfo(@RequestParam(value="ipList") String ipList,Model model){
        try {
            model.addAttribute("result",ipService.queryByIP(ipList));
        } catch (Exception e) {
            logger.error("出错了",e);
            e.printStackTrace();
        }
        return "index";
    }


}
