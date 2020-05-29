package com.ensa.salle.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	private String name;
	
    private int positions = 0;
    
    private int computers = 0;
    
    private String network = "NO";
    
    private String projector = "NO";
    
    private String speakers = "NO";
    
    private String conditioning = "NO";
    
    private String board = "NO";
    
    @JsonDeserialize
    @ManyToOne
    @NotNull
    private Department department; 
}
