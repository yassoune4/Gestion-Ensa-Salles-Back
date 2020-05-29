package com.ensa.salle.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.salle.config.JwtTokenUtil;
import com.ensa.salle.entities.JwtResponse;
import com.ensa.salle.entities.User;
import com.ensa.salle.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired 
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	private List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	private Optional<User> getUser(@PathVariable Long userId){
		return userService.getUserById(userId);
	}
	
	@PostMapping("/signin")
	private ResponseEntity<JwtResponse> getUserByEmail(@RequestBody(required = true) Map<String,Object> emailobj){
		String email = (String) emailobj.get("email");
		User user = userService.getUserByEmail(email).get();
		final String token = jwtTokenUtil.generateToken((UserDetails) user);

		return ResponseEntity.ok(new JwtResponse(token));
		//return userService.getUserByEmail(email);
	}
	
	@PostMapping("/user/new")
	private User saveUser(@RequestBody(required = true)  User user){
		return userService.saveUser(user);
	}

}
