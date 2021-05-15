package com.example.demo.hello.controller;

import com.example.demo.hello.bean.SwaggerBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Api(tags="Swagger模块")  // API 资源
@RequestMapping("/swagger")
public class SwaggerController {

    @ApiOperation("获取swaggers列表信息")   // 描述特定请求资源
    @GetMapping("/swaggers")
    public List<SwaggerBean> swaggers(){
        return SwaggerBean.swaggers();
    }

    @ApiOperation("保存swagger")
    @PutMapping("/swaggers")
    public boolean swaggers(SwaggerBean swaggerBean){
        return SwaggerBean.save(swaggerBean);
    }

    @ApiOperation("删除swagger")
    @DeleteMapping("/swaggers")
    public boolean delete(Long id){
        return SwaggerBean.deleteById(id);
    }


    @ApiOperation("根据id获取swagger")
    @GetMapping("/swaggers/{id}")
    public SwaggerBean swaggers(@PathVariable("id") Long id){
        return SwaggerBean.selectById(id);
    }
    
}
