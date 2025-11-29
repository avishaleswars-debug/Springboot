package com.code.springbootdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class UserEntity {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
public UserEntity(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
public UserEntity() {
	super();
}
private String name;
private String email;

}
