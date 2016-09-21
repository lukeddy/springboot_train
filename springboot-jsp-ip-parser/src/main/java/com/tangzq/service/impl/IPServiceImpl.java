package com.tangzq.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tangzq.model.IPResponse;
import com.tangzq.service.IPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Service
public class IPServiceImpl  implements IPService{

    private static final Logger logger= LoggerFactory.getLogger(IPServiceImpl.class);

    @Value("${api.ipquery.baidu.apistore}")
    private String ipQueryURL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private  HttpEntity<String> entity;
    private  Map<String,Object> params;

    @PostConstruct
    public void init(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apikey","bcc2b484f786d08bab600190ffcb76df");
        entity = new HttpEntity("parameters", headers);
        params=new HashMap();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("GBK")));
    }


    @Override
    public IPResponse queryByIP(String ip)throws Exception {
        Map<String,Object> params=new HashMap();
        params.put("ip",ip);
        HttpEntity<String> responseEntity=restTemplate.exchange(ipQueryURL, HttpMethod.GET,entity,String.class,params);
        logger.info("ip{},查询到结果为{}",ip,responseEntity.getBody());
       return  objectMapper.readValue(responseEntity.getBody(),IPResponse.class);
    }
}
