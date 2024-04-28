package com.saloonbookingapi.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saloonbookingapi.entity.CategoryEntity;
import com.saloonbookingapi.entity.User;
import com.saloonbookingapi.service.CategoryService;
import com.saloonbookingapi.service.UserService;

@RestController
public class CategoryController {
	
	
	@Autowired
	public CategoryService service;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addCategory")
	public CategoryEntity add(@RequestBody CategoryEntity entity) {
		CategoryEntity catEntity = null;
		System.out.println(entity.toString());

		 catEntity = service.add(entity);
		System.out.println("userEntity:" + catEntity);
		
		return catEntity;
	}
	
	@GetMapping("/categoryList")
	public List<CategoryEntity> list() {
		return service.list();
	}
	
	@PatchMapping("/updateCategory")
	public List<CategoryEntity> update(@RequestBody CategoryEntity entity) {
		return service.update(entity);
	}
	
	@DeleteMapping("/deleteCategory")
	public List<CategoryEntity> delete(@RequestParam long id) {
		return service.delete(id);
	}

}
