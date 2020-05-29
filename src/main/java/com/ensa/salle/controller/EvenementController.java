package com.ensa.salle.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.salle.entities.Evenement;
import com.ensa.salle.entities.User;
import com.ensa.salle.services.EvenementService;
import com.ensa.salle.services.UserService;

@RestController
@RequestMapping("/api/evenements")
public class EvenementController {
	
	@Autowired
	private EvenementService evenementService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	private List<Evenement> getEvenements(){
		return evenementService.getAllEvenements();
	}
	
	@GetMapping("/{evenementId}")
	private Optional<Evenement> getEvenement(@PathVariable Long evenementId){
		return evenementService.getEvenementById(evenementId);
	}
	
	@GetMapping("/user/{userId}")
	private List<Evenement> getEvenementsByUser(@PathVariable Long userId){
		User user = userService.getUserById(userId).get();
		return evenementService.getEvenementsByUser(user);
	}
	
	@PostMapping("/evenement/new")
	private Evenement saveUser(@RequestBody(required = true)  Evenement evenement){
		return evenementService.saveEvenement(evenement);
	}

}
