package com.infy.admin.pojo;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class UserLogIn {
	@Field(value = "email")
	private String email;
	
	@Field(value = "password")
	private String password;

}
