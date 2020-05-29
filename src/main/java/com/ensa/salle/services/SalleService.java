package com.ensa.salle.services;

import java.util.List;
import java.util.Optional;

import com.ensa.salle.entities.Department;
import com.ensa.salle.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.salle.repositories.SalleDAO;

@Service
public class SalleService {
	
	@Autowired
	private SalleDAO salleRepository;
	
	public Salle saveSalle(Salle salle)
	{
		return salleRepository.save(salle);
	}
	
	public Optional<Salle> getSalleById(Long id)
	{
		return salleRepository.findById(id);
	}
	
	public List<Salle> getSalleByDepartment(Department dep)
	{
		return salleRepository.findByDepartment(dep);
	}
	
	public List<Salle> getAllSalles()
	{
		return salleRepository.findAll();
	}

}
