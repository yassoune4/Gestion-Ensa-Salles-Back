package com.ensa.salle.services;

import com.ensa.salle.entities.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.salle.repositories.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userRepository;
	
	public User saveUser(User user)
	{
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id)
	{
		return userRepository.findById(id);
	}
	
	public Optional<User> getUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	public Optional<User> getUserByUsername(String name)
	{
		return userRepository.findByUsername(name);
	}
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

}
