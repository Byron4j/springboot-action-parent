package com.example.demo.hello.controller;

import com.example.demo.hello.bean.HelloBean;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public HelloBean hello() {
        return HelloBean.builder().id(1L).firstname("sanfeng").lastname("zhang").build();
    }
}
