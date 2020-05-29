package com.ensa.salle.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.salle.entities.Department;
import com.ensa.salle.repositories.DepartmentDAO;

import java.util.List;

@Service
public class DepartmentService {
		@Autowired
		private DepartmentDAO departmentRepository;
		
		public Department saveDepartment(Department department)
		{
			return departmentRepository.save(department);
		}
		
		public Optional<Department> getDepartmentById(Long id)
		{
			return departmentRepository.findById(id);
		}
		
		public List<Department> getAllDepartments()
		{
			return departmentRepository.findAll();
		}
		
		
}
