package com.ensa.salle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.salle.entities.Department;

public interface DepartmentDAO extends JpaRepository<Department, Long>{

}
