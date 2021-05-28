package com.example.demo.hello;

import com.example.demo.hello.bean.Person;
import com.example.demo.hello.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {


    @Autowired
    private FriendDAO friendDAO;  //  listOperations
    @Autowired
    private FamilyDAO familyDAO;  // setOperations
    @Autowired
    private EmployeeDAO empDAO;   // hashOperations
    @Autowired
    private UserDAO userDAO;      //  stringRedisTemplate
    @Autowired
    private FriendWithRedisTemplateDAO friendWithRedisTemplateDAO;   //  redisTemplate

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person(1, "Mahesh", 30);
        friendDAO.addFriend(p1);
        Person p2 = new Person(2, "Krishna", 35);
        friendDAO.addFriend(p2);
        System.out.println("Number of friends: " + friendDAO.getNumberOfFriends());
        System.out.println(friendDAO.getFriendFromIndex(1));
        friendDAO.removeFriend(p2);
        System.out.println(friendDAO.getFriendFromIndex(1));


        System.out.println("--Example of SetOperations--");
        Person p11 = new Person(101, "Ram", 30);
        Person p12 = new Person(102, "Lakshman", 25);
        Person p13 = new Person(103, "Bharat", 35);
        familyDAO.addFamilyMembers(p11, p12, p13);
        System.out.println("Number of Family members: " + familyDAO.getNumberOfFamilyMembers());
        System.out.println(familyDAO.getFamilyMembers());
        System.out.println("No. of Removed Family Members: " + familyDAO.removeFamilyMembers(p11, p12));
        System.out.println(familyDAO.getFamilyMembers());

        System.out.println("--Example of HashOperations--");
        Person emp1 = new Person(11, "Ravan", 45);
        Person emp2 = new Person(12, "Kumbhkarn", 35);
        Person emp3 = new Person(13, "Vibhisan", 25);
        empDAO.addEmployee(emp1);
        empDAO.addEmployee(emp2);
        empDAO.addEmployee(emp3);
        System.out.println("No. of Employees: "+ empDAO.getNumberOfEmployees());
        System.out.println(empDAO.getAllEmployees());
        emp2.setAge(20);
        empDAO.updateEmployee(emp2);
        System.out.println(empDAO.getEmployee(12));


        System.out.println("--Example of StringRedisTemplate--");
        userDAO.addUserName("sriram");
        System.out.println(userDAO.getUserName());
        userDAO.updateUserName("srikrishna");
        System.out.println(userDAO.getUserName());
        userDAO.deleteUser();
        System.out.println(userDAO.getUserName()); //It will return null, because value is deleted.


    }
}
