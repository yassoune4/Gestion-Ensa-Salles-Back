package com.ensa.salle.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.salle.entities.Evenement;
import com.ensa.salle.entities.User;
import com.ensa.salle.repositories.EvenementDAO;

@Service
public class EvenementService {

	@Autowired
	private EvenementDAO evenementRepository;
	
	public Evenement saveEvenement(Evenement evenement)
	{
		return evenementRepository.save(evenement);
	}
	
	public Optional<Evenement> getEvenementById(Long id)
	{
		return evenementRepository.findById(id);
	}
	
	public List<Evenement> getAllEvenements()
	{
		return evenementRepository.findAll();
	}
	
	public List<Evenement> getEvenementsByUser(User user)
	{
		return evenementRepository.findByUser(user);
	}
	
}
