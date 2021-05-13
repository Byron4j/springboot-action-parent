package com.example.demo.hello.controller;


import com.example.demo.hello.bean.Person;
import com.example.demo.hello.service.PersonService;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons/{id}")
    public Person persons(@PathVariable("id") Long id){
        Person persons = personService.persons(id);
        return persons;
    }

    @GetMapping("/persons")
    public List<Person> persons(){
        List<Person> persons = personService.persons();
        return persons;
    }
}
