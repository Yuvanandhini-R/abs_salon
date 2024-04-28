package com.saloonbookingapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.saloonbookingapi.entity.User;





public interface UserRepository extends JpaRepository<User, Long> {
    //username , it will return the user of given username
    public User findByUsername(String username);
}
