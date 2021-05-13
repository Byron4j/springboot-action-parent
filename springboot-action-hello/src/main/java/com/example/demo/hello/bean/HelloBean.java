package com.example.demo.hello.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloBean {
    private Long id;
    private String firstname;
    private String lastname;
}
