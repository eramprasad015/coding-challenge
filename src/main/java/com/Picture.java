package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Picture {
	@Column(unique=true, nullable=false, updatable=false)
	private @Id @GeneratedValue Long id;
	
	private String large;
	
	private String medium;
	
	private String thumbnail;

}
