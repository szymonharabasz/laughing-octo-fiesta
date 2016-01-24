package com.szymonharabasz.miniforum.repository;

import java.util.List;

import com.szymonharabasz.miniforum.User;

public interface UsersRepository {
	List<User> getAllUsers();
	User getUserById(long id);
	void saveUser(User user);
}
