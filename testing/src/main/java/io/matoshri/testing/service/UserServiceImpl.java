package io.matoshri.testing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.matoshri.testing.exception.UserNotFoundException;
import io.matoshri.testing.model.User;
import io.matoshri.testing.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repo;

	@Autowired
	public UserServiceImpl(UserRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return this.repo.save(user);
	}

	@Override
	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		if (this.repo.existsById(id)) {
			return this.repo.saveAndFlush(user);
		} else {
			throw new UserNotFoundException("User not found" + id);
		}
	}

	@Override
	public List<User> getUserByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public Map<String, Boolean> deleteUser(int id) {
		boolean deleted = true;
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		if (this.repo.existsById(id)) {
			this.repo.deleteById(id);
		}
		response.put("Deleted", deleted);
		return response;
	}

}
