package com.saloonbookingapi.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saloonbookingapi.entity.User;
import com.saloonbookingapi.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/registration")
	public ResponseEntity<?> createUser(@RequestBody User entity) {
		
		System.out.println(entity.toString());

		ResponseEntity<?> userEntity = userService.CreateUser(entity);
		System.out.println("userEntity:" + userEntity);
		
		return userEntity;
	}

}
