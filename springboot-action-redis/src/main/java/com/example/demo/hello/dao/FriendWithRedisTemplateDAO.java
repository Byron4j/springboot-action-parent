package com.example.demo.hello.dao;

import com.example.demo.hello.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FriendWithRedisTemplateDAO {

    private static final String KEY = "friendsKey";

    @Autowired
    private RedisTemplate<String, Person> redisTemplate;

    public void addFriend(Person person) {
        redisTemplate.opsForList().leftPush(KEY, person);
    }
    public long getNumberOfFriends() {
        return redisTemplate.opsForList().size(KEY);
    }
    public Person getFriendAtIndex(Integer index) {
        return redisTemplate.opsForList().index(KEY, index);
    }
    public void removeFriend(Person p) {
        redisTemplate.opsForList().remove(KEY, 1, p);
    }
}
