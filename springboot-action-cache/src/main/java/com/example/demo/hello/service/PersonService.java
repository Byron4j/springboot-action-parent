package com.example.demo.hello.service;


import com.example.demo.hello.bean.Person;

import java.util.List;

public interface PersonService {
    Person persons(Long id);
    List<Person> persons();
}
