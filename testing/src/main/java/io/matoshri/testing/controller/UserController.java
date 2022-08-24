package io.matoshri.testing.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.matoshri.testing.model.User;
import io.matoshri.testing.service.UserService;

@RestController
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return this.service.getAllUsers();
	}
	
	@GetMapping("{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return this.service.getUserByName(name);
	}
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return this.service.saveUser(user);
	}
	
	@PutMapping("{id}")
	public User updateUser(@PathVariable int id,@RequestBody User user) {
		return this.service.updateUser(id, user);
	}
	
	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteUserById(@PathVariable int id) {
		return this.service.deleteUser(id);
	}
}
