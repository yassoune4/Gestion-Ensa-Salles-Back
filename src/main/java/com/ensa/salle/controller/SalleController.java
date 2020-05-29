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

import com.ensa.salle.entities.Department;
import com.ensa.salle.entities.Salle;
import com.ensa.salle.services.DepartmentService;
import com.ensa.salle.services.SalleService;

@RestController
@RequestMapping("/api/salles")
public class SalleController {
	
	@Autowired
	private SalleService salleService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/")
	private List<Salle> getSalles(){
		return salleService.getAllSalles();
	}
	
	@GetMapping("/{salleId}")
	private Optional<Salle> getSalle(@PathVariable Long salleId){
		return salleService.getSalleById(salleId);
	}
	
	@GetMapping("/department/{departmentId}")
	private List<Salle> getSalleByDep(@PathVariable Long departmentId){
		Department dep  = departmentService.getDepartmentById(departmentId).get();
		return salleService.getSalleByDepartment(dep);
	}
	
	@PostMapping("/salle/new")
	private Salle saveDepartment(@RequestBody(required = true)  Salle salle){
		return salleService.saveSalle(salle);
	}

}
