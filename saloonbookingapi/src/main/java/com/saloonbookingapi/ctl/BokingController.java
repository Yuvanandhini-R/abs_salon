package com.saloonbookingapi.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saloonbookingapi.entity.User;
import com.saloonbookingapi.model.CustomUserDetails;
import com.saloonbookingapi.entity.BookingEntity;
import com.saloonbookingapi.entity.CategoryEntity;
import com.saloonbookingapi.service.BookingService;
import com.saloonbookingapi.service.CategoryService;
import com.saloonbookingapi.service.UserService;

@RestController
public class BokingController {
	
	@Autowired
	public BookingService service;
	
	@Autowired
	public CategoryService categoryService;
	
	@Autowired
	public UserService userService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/booking")
	public BookingEntity add(@RequestBody BookingEntity entity) {
		BookingEntity bookEntity = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		
		User uDto = userService.findUserByUserName(user.getUsername());
		CategoryEntity caEntity = categoryService.findByCatName(entity.getCategoryName());
		
		System.out.println(entity.toString());
          entity.setPrice(caEntity.getPrice());
          entity.setStatus("Booked");
          entity.setUserId(uDto.getId());
          entity.setUsername(uDto.getUsername());
		
		
		bookEntity = service.add(entity);
		System.out.println("BookingEntity:" + bookEntity);
		
		return bookEntity;
	}
	
	@GetMapping("/bookingList")
	public List<BookingEntity> list() {
		return service.list();
	}

}
