package com.home.portfoliomanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Document(collection = "col_user")
public class UserProfile {
	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value = "name")
	private String name;
	
	@Field(value = "email")
	private String email;
	
	@Field(value = "password")
	private String password;
	
	@Field(value = "hasAgreed")
	private String hasAgreed;
	
}
