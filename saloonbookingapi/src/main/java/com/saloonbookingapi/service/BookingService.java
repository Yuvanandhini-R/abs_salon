package com.saloonbookingapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saloonbookingapi.entity.BookingEntity;
import com.saloonbookingapi.entity.CategoryEntity;
import com.saloonbookingapi.repository.BookingRepository;
import com.saloonbookingapi.repository.CategoryRepository;

@Service
public class BookingService {
	
	@Autowired
	public BookingRepository repository;
	
	
	public BookingEntity add(BookingEntity entity) {
		BookingEntity catE = null;
        try {
          	catE = repository.save(entity);
        		
        }catch (Exception e) {
			// TODO: handle exception
		}
		return catE;
	}

	public List<BookingEntity> list() {
          return repository.findAll();
	}

	public List<BookingEntity> update(BookingEntity entity) {
		repository.saveAndFlush(entity);
		 return repository.findAll();

	}

	public List<BookingEntity> delete(long id) {
		
		repository.deleteById(id);
		return repository.findAll();

	}


}
