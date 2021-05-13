package com.example.demo.hello.service.impl;


import com.example.demo.hello.bean.Person;
import com.example.demo.hello.dao.PersonRepository;
import com.example.demo.hello.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Cacheable(cacheNames = "springboot:cache", key = "#id", unless = "#id == null")
    @Override
    public Person persons(Long id) {
        log.info("根据id获取person数据");
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> persons() {

        Iterable<Person> all = personRepository.findAll();
        List<Person> list = new LinkedList<>();
        all.forEach(ele->list.add(ele));
        return list;

    }

}
