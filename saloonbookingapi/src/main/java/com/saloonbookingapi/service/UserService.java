package com.saloonbookingapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.saloonbookingapi.entity.User;
import com.saloonbookingapi.exception.RecordNotFoundException;
import com.saloonbookingapi.repository.UserRepository;

@Service
public class UserService  {
	
	@Autowired
	public UserRepository userRepository;

	
	public ResponseEntity<?> CreateUser(User entity) {
		User userEntity = null;
		try {
			User user = userRepository.findByUsername(entity.getUsername());
			if(user == null) {
				userEntity = userRepository.save(entity);
			}else {
				System.out.println("Duplicate username");
				throw new RecordNotFoundException("User name is already available");
			}
		}catch (Exception e) {
			
			throw new RecordNotFoundException("User name is already available");
		}
		return new ResponseEntity<>(userEntity,HttpStatus.OK);
	}
	

	public User findUserByUserName(String uname) {
		
      return  userRepository.findByUsername(uname);
	}

}
