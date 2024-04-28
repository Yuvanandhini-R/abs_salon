package com.saloonbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saloonbookingapi.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
	public CategoryEntity findById(long id);
	public CategoryEntity findByCategoryName(String name);

}
