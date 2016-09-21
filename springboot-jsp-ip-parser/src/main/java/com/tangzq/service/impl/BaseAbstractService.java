package com.tangzq.service.impl;


import com.tangzq.util.Constants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Random;

public abstract class BaseAbstractService {

    public HttpEntity<String> createEntiryWithAgent(MediaType mediaType){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        Random rand = new Random();
        String userAgent= Constants.AGENT_ARR[rand.nextInt(Constants.AGENT_ARR.length)];
        headers.set("User-Agent",userAgent);
        return new HttpEntity("parameters", headers);
    }

    public HttpEntity<String> createJSONEntiryWithAgent(){
        return createEntiryWithAgent(MediaType.APPLICATION_JSON);
    }
}
