package com.zheok.pufeite.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

@RestController
@CrossOrigin
@RequestMapping("/tripartite")
public class TripartiteController {
    private static final String URL = "http://openapi.300.cn/openapi/enquiry/save.do";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    private String tripartite(HttpServletRequest request, @RequestBody JSONObject json){
//        String authorization = request.getHeader("Authorization");
        String authorization = "Bearer 6cbb5b3c-70e1-4c9d-aaa2-ea1033bb6ae6";
        String header = request.getHeader("App-Key");
        String version = request.getHeader("api-version");
        //组装请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", authorization);
        headers.add("App-Key", header);
        headers.add("api-version", version);
        //组装请求头和参数
        HttpEntity<String> requestParam = new HttpEntity<>(MessageFormat.format("formData={0}",JSON.toJSONString(json)), headers);
        return restTemplate.postForObject(URL, requestParam, String.class);
    }
}
