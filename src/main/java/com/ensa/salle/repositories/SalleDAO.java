package com.ensa.salle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.salle.entities.Department;
import com.ensa.salle.entities.Salle;
import com.ensa.salle.entities.User;

public interface SalleDAO extends JpaRepository<Salle, Long> {
	List<Salle> findByDepartment(Department department);

}
