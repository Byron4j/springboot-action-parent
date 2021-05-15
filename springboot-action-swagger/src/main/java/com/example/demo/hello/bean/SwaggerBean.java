package com.example.demo.hello.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.Swagger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "SwaggerBean POJO" )
public class SwaggerBean {
    @ApiModelProperty(name = "id", value = "编号，唯一")
    private Long id = 1L;
    @ApiModelProperty(name = "version", value = "版本")
    private String version = "V1.0.0.0";
    @ApiModelProperty(name = "desc", value = "描述信息")
    private String desc = "SpringBoot-Swagger接口";

    private static SwaggerBean INSTANCE = new SwaggerBean();

    private static List<SwaggerBean> SWAGGERS_LIST = new LinkedList<>();
    static {
        SWAGGERS_LIST.add(INSTANCE);
    }

    public static List<SwaggerBean> swaggers(){
        return SWAGGERS_LIST;
    }

    public static SwaggerBean DEFAULT(){
        return INSTANCE;
    }


    public static boolean save(SwaggerBean swaggerBean){
        Iterator<SwaggerBean> it = SWAGGERS_LIST.iterator();
        while (it.hasNext()) {
            SwaggerBean next = it.next();
            if (next.getId().equals(swaggerBean.id)) {
                return false;
            }
        }
        return SWAGGERS_LIST.add(swaggerBean);
    }

    public static void update(SwaggerBean swaggerBean){
        Iterator<SwaggerBean> it = SWAGGERS_LIST.iterator();
        while (it.hasNext()) {
            SwaggerBean next = it.next();
            if (next.getId().equals(swaggerBean.id)) {
                next.setVersion(swaggerBean.getVersion());
                next.setDesc(swaggerBean.getDesc());
            }
        }
    }

    public static boolean deleteById(Long id){
        Iterator<SwaggerBean> it = SWAGGERS_LIST.iterator();
        while (it.hasNext()) {
            SwaggerBean next = it.next();
            if (next.getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public static SwaggerBean selectById(Long id){
        Iterator<SwaggerBean> it = SWAGGERS_LIST.iterator();
        while (it.hasNext()) {
            SwaggerBean next = it.next();
            if (next.getId().equals(id)) {
                return next;
            }
        }
        return null;
    }
}
