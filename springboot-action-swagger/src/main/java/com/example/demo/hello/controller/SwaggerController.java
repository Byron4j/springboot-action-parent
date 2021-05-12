package com.example.demo.hello.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags="接口")
public class SwaggerController {
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }
}
