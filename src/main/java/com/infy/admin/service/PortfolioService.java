package com.infy.admin.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.infy.admin.model.UserProfile;
import com.infy.admin.pojo.UserLogIn;
import com.infy.admin.repository.UserRepository;

@Component
public class PortfolioService {
	protected final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private UserRepository userRepo;
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	
	public UserProfile addUserProfile(UserProfile userProfile) {	
		logger.info("Saving user profile...");
		if(userRepo.findByEmail(userProfile.getEmail()).size()==0)
			return userRepo.save(userProfile);	
		else
			return null;
	}
	
	public UserProfile findUser(UserLogIn userDetails) {	
		return userRepo.findByEmailAndPassword(userDetails.getEmail(),userDetails.getPassword());	
	}
	

}
