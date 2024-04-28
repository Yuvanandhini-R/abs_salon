package com.saloonbookingapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.saloonbookingapi.entity.CategoryEntity;
import com.saloonbookingapi.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository repository;
	
	
	public CategoryEntity add(CategoryEntity entity) {
		CategoryEntity catE = null;
        try {
        
        	CategoryEntity eDto =	repository.findByCategoryName(entity.getCategoryName());
        	if(eDto == null) {
        		catE = repository.save(entity);
        	}else {
        		throw new Exception("This Category is already available..");
        	}	
        }catch (Exception e) {
			// TODO: handle exception
		}
		return catE;
	}

	public List<CategoryEntity> list() {
          return repository.findAll();
	}

	public List<CategoryEntity> update(CategoryEntity entity) {
		repository.saveAndFlush(entity);
		 return repository.findAll();

	}
	
	public CategoryEntity findByCatName(String name) {
		
		 return repository.findByCategoryName(name);

	}

	public List<CategoryEntity> delete(long id) {
		
		repository.deleteById(id);
		return repository.findAll();

	}

}
