package com.example.demo.hello.dao;

import com.example.demo.hello.bean.Person;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Set;

@Repository
public class FamilyDAO {
    private static final String KEY = "myFamilyKey";

    @Resource(name="redisTemplate")
    private SetOperations<String, Person> setOperations;

    // add multi members
    public void addFamilyMembers(Person... persons){
        setOperations.add(KEY, persons);
    }

    // get all members
    public Set<Person> getFamilyMembers(){
        return setOperations.members(KEY);
    }

    // size
    public long getNumberOfFamilyMembers(){
        return setOperations.size(KEY);
    }

    // remove
    public long removeFamilyMembers(Person... persons){
        return setOperations.remove(KEY, (Object[]) persons);
    }

}
