package com.movie.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.domain.User;
import com.movie.demo.repository.UserRepository;
import com.movie.demo.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		
		return this.userRepository.findById(userId).get();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public User updateUser(User updatedUser, Integer user_id) {
		User userDb=this.userRepository.findById(user_id).get();
		userDb.setName(updatedUser.getName());
		userDb.setName(updatedUser.getEmail());
		return this.userRepository.save(userDb);
	}

	@Override
	public void deleteUserById(Integer user_id) {
		this.userRepository.deleteById(user_id);
		
	}

}
