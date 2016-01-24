package com.szymonharabasz.miniforum.service;

import java.util.List;

import com.szymonharabasz.miniforum.User;

public interface UsersService {
	List<User> getAllUsers();
	User getUserById(long id);
	void saveUser(User user);
	long getFirstFreeId();
}
