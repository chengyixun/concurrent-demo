package com.example.concurrentlearn.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserDao {


    public void query(){
        System.out.println("query db=======");
    }
}
