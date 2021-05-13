package com.example.demo.hello.dao;

import com.example.demo.hello.bean.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
