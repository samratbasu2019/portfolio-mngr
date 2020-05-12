package com.home.portfoliomanager.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.portfoliomanager.model.UserProfile;
import com.home.portfoliomanager.pojo.UserLogIn;
import com.home.portfoliomanager.repository.UserRepository;

@Component
public class PortfolioService {
	protected final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private UserRepository userRepo;
	
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
