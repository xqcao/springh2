package com.user.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
