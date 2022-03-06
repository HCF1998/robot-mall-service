package com.h2.robotmallservice.repository;

import com.h2.robotmallservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByUserName(String userName);
}
