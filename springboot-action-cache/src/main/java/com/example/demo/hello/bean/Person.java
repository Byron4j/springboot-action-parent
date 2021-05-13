package com.example.demo.hello.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Long id;
    private String firstname;
    private String lastname;
}