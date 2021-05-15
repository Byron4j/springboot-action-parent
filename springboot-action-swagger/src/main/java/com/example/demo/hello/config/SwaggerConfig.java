package com.example.demo.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //.pathMapping("com.example.demo")   这是 basePath
                .globalRequestParameters(globalRequestParameters());
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot-Swagger接口")
                .description("SpringBoot-Swagger整合示例")
                .version("1.0.0")
                //.license("MIT")
                .contact(new Contact("青山师", "https://blog.csdn.net/zixiao217", ""))
                //.termsOfServiceUrl("https://blog.csdn.net/zixiao217")
                .build();
    }

    private List<RequestParameter> globalRequestParameters() {
        List<RequestParameter> parameterList = new ArrayList<>();
        RequestParameter region = new RequestParameterBuilder()
                .name("region").in(ParameterType.HEADER).description("区域").required(false).build();

        parameterList.add(region);
        return parameterList;
    }
}
