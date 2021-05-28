package com.example.demo.hello.dao;

import com.example.demo.hello.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class EmployeeDAO {
    private static final String KEY = "employeesKey";

    @Resource(name = "redisTemplate")
    private HashOperations<String, Integer, Person> hashOperations;

    public void addEmployee(Person person){
        hashOperations.putIfAbsent(KEY, person.getId(), person);
    }

    public void updateEmployee(Person person) {
        hashOperations.put(KEY, person.getId(), person);
    }
    public Person getEmployee(Integer id) {
        return hashOperations.get(KEY, id);
    }
    public long getNumberOfEmployees() {
        return hashOperations.size(KEY);
    }
    public Map<Integer, Person> getAllEmployees() {
        return hashOperations.entries(KEY);
    }
    public long deleteEmployees(Integer... ids) {
        return hashOperations.delete(KEY, (Object)ids);
    }


}
