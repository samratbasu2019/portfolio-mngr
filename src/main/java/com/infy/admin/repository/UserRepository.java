package com.infy.admin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infy.admin.model.UserProfile;

@Repository
public interface UserRepository extends MongoRepository<UserProfile, String> {
	
	public UserProfile findByEmailAndPassword(String email, String password);
	public List<UserProfile> findByEmail(String email);

}
