package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Coordinates {
	@Column(unique=true, nullable=false, updatable=false)
	private @Id @GeneratedValue Long id;
	
	private String latitude;
	private String longitude;
}
