package com.movie.demo.service;

import java.util.List;

import com.movie.demo.domain.User;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(Integer userId);

	User addUser(User user);

	User updateUser(User updatedUser, Integer user_id);

	void deleteUserById(Integer user_id);
}
