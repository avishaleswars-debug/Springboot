package com.code.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.springbootdemo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
