package com.example.demo.hello.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName="testdoct", type = "test")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestBean {
    @Id
    private long id;
    @Field(analyzer="ik_smart")
    private String name;
    private Integer age;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String sex;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String desc;
}
