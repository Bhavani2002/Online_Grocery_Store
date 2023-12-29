package com.edubridge.app1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.edubridge.app1.model.User;
import com.edubridge.app1.repo.RegistrationRepository;

@Service
public class RegistrationService {
	
	 @Autowired
	 private RegistrationRepository repo;
	 
     public User saveUser(User user) { 
    	 return repo.save(user);
     }
	
     public User fetchUserByEmailId(String email) {
    	 return repo.findByEmailId(email);
     }
     
     public User fetchUserByEmailIdAndPassword(String email, String password) {
    	 return repo.findByEmailIdAndPassword(email, password);
     }
}

