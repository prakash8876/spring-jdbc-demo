package io.matoshri.testing.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.matoshri.testing.exception.UserNotFoundException;
import io.matoshri.testing.model.User;

@Component
public interface UserService {
	
	List<User> getAllUsers();
	
	User saveUser(User user);
	
	User updateUser(int id, User user) throws UserNotFoundException;
	
	List<User> getUserByName(String name);
	
	Map<String, Boolean> deleteUser(int id) throws UserNotFoundException;
	
}
