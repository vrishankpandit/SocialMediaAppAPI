package com.example.resfulwebservices.restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resfulwebservices.restful_web_services.user.User;


public interface UserRepository extends JpaRepository<User,Integer>{

}
