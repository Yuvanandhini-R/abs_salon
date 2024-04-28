package com.saloonbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saloonbookingapi.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

	public BookingEntity findById(long id);
}
