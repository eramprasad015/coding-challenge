package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Timezone {
	@Column(unique=true, nullable=false, updatable=false)
	private @Id @GeneratedValue Long id;
	
	@Column(name="Timezone_Offset")
	private String offset;
	private String description;
}
