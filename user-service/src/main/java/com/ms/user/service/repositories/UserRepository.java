package com.ms.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
