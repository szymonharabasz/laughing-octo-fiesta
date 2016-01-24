package com.szymonharabasz.miniforum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szymonharabasz.miniforum.User;
import com.szymonharabasz.miniforum.repository.UsersRepository;
import com.szymonharabasz.miniforum.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<User> getAllUsers() {
		return usersRepository.getAllUsers();
	}

	@Override
	public User getUserById(long id) {
		return usersRepository.getUserById(id);
	}

	@Override
	public void saveUser(User user) {
		usersRepository.saveUser(user);
	}

	@Override
	public long getFirstFreeId() {
		long id = 1;
		User foundUser = null;
		while (foundUser == null) {
			try {
				foundUser = usersRepository.getUserById(id);
			}
			catch (IllegalArgumentException e) {
				// Do nothing
				++id;
			}
		}
		return id;
	}

}
