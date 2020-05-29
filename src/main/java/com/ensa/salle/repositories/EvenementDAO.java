package com.ensa.salle.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.salle.entities.Evenement;
import com.ensa.salle.entities.User;


public interface EvenementDAO extends JpaRepository<Evenement, Long> {
	List<Evenement> findByUser(User user);

}
