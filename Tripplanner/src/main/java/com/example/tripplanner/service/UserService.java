package com.example.tripplanner.service;

import com.example.tripplanner.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User login(String email, String password);
    User updateUserById(Long userId, User user);
    User updateUserByEmail(String email, User user);
    User updatePasswordByEmail(String email, String newPassword);
    void deleteUser(Long userId);
    User findUserByEmail(String email);
	User login(User user);
	User getByEmailAndPassword(String email, String password);
	User findUserByUserMobileNo(String userMobileNo);
}
