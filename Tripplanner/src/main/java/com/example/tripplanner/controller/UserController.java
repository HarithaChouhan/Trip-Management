package com.example.tripplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripplanner.model.User;
import com.example.tripplanner.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @GetMapping("/id/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    
    @GetMapping("/email/{email}")
    public User findUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
    @GetMapping("/forgotpass/{email}")
    public User findUserByEmail1(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
    
    @GetMapping("/phone/{userMobileNo}")
    public User findUserByMobileNo(@PathVariable String userMobileNo) {
        return userService.findUserByUserMobileNo(userMobileNo);
    }
    
    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUserById(userId, user);
    }
    
    @DeleteMapping("/delete/{userId}")
    public List<User> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
       return  userService.getAllUsers();
    }
    @PutMapping("/update/{email}/{password}")
    public User updateByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        return userService.updatePasswordByEmail(email, password);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        return new ResponseEntity<User>(userService.login(user),HttpStatus.OK);
    }
//    @GetMapping("/login/{mail}/{pass}")
//    public ResponseEntity<User> login(@PathVariable("mail") String email, @PathVariable("pass") String password) {
//        return new ResponseEntity<User>(userService.login(email, password),HttpStatus.OK);
//    }

@PutMapping("/updatepassword/{pass}")
public ResponseEntity<User> updatePassword(@RequestParam String email, @RequestParam String newPassword) {
    User updatedUser = userService.updatePasswordByEmail(email, newPassword);
    if (updatedUser != null) {
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   }
@PutMapping("/updateUser/{email}")
public User updateUserByEmail(@PathVariable("email")String email,@RequestBody User user){
	return userService.updateUserByEmail(email, user);
}
}
