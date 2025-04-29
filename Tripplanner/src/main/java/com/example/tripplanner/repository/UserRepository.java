package com.example.tripplanner.repository;

import com.example.tripplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findByUserMobileNo(String userMobileNo);
    User findByEmailAndPassword(String email, String password);

}

