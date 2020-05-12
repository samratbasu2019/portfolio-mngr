package com.home.portfoliomanager.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.portfoliomanager.model.UserProfile;
import com.home.portfoliomanager.pojo.UserLogIn;
import com.home.portfoliomanager.service.PortfolioService;
import com.home.portfoliomanager.util.ResponseHelper;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PortfolioManagerController {
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	PortfolioService ps;
		
	@PostMapping(value="/createUser")
	public ResponseEntity<?> createUser(@RequestParam String track_id, @RequestBody UserProfile userProfile) {
		logger.info("Userprofile details name "+userProfile.getName()+" has Agreed "+userProfile.getHasAgreed());
		UserProfile up = null;
		if (Boolean.valueOf(userProfile.getHasAgreed())) {
			try {
			up=ps.addUserProfile(userProfile);
			}catch(Exception ex) {
				ex.printStackTrace();
				return new ResponseEntity<>(ex.getCause().toString(), HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>(ResponseHelper.populateRresponse("Pls check input parameters","failure"), HttpStatus.OK);
		}
		return new ResponseEntity<>(
			up!=null?
			ResponseHelper.populateRresponse("User details saved.","success"):
			ResponseHelper.populateRresponse("This user has already registered! Pls sign-in.","failure"), HttpStatus.OK);
	}
	
	@PostMapping(value="/findUser")
	public ResponseEntity<?> findUser(@RequestParam String track_id,@RequestBody UserLogIn userLogIn) {		
		return new ResponseEntity<>(ps.findUser(userLogIn)!=null?
				ResponseHelper.populateRresponse("User profile found.","success")
				:ResponseHelper.populateRresponse("User doesn't exist or user name and password are incorrect!","failure"), HttpStatus.OK);
	}
}
