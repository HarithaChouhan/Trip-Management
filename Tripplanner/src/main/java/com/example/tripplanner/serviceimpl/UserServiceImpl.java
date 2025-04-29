package com.example.tripplanner.serviceimpl;

import com.example.tripplanner.model.User;
import com.example.tripplanner.repository.UserRepository;
import com.example.tripplanner.service.UserService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User updateUserById(Long userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setAddress(updatedUser.getAddress());
            user.setUserMobileNo(updatedUser.getUserMobileNo());
            user.setUserAge(updatedUser.getUserAge());
            user.setUserGender(updatedUser.getUserGender());
            user.setUserFavourite(updatedUser.getUserFavourite());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUserByEmail(String email, User updatedUser) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setAddress(updatedUser.getAddress());
            user.setUserAge(updatedUser.getUserAge());
            user.setUserMobileNo(updatedUser.getUserMobileNo());
            user.setPassword(updatedUser.getPassword());
            user.setUserGender(updatedUser.getUserGender());
            user.setUserFavourite(updatedUser.getUserFavourite());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updatePasswordByEmail(String email, String newPassword) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            user.setPassword(newPassword);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByUserMobileNo(String userMobileNo) {
        return userRepository.findByUserMobileNo(userMobileNo);
    }

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPassword( user.getEmail(), user.getPassword());
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPassword(email, password);
	}
}
