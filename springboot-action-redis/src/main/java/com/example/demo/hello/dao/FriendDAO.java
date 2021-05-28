package com.example.demo.hello.dao;

import com.example.demo.hello.bean.Person;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

// ListOperations
@Repository
public class FriendDAO {
    private static final String KEY = "friendsKey";

    @Resource(name = "redisTemplate")
    private ListOperations<String, Person> listOperations;

    // add
    public void addFriend(Person person){
        listOperations.leftPush(KEY, person);
    }
    // size
    public long getNumberOfFriends(){
       return listOperations.size(KEY);
    }
    // get friend from index
    public Person getFriendFromIndex(Integer index){
        return listOperations.index(KEY, index);
    }
    // remove
    public void removeFriend(Person p) {
        listOperations.remove(KEY, 1, p);
    }
}
