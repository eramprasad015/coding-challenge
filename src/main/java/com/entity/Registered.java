package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Registered {
	@Column(unique=true, nullable=false, updatable=false)
	private @Id @GeneratedValue Long id;
	
	private String date;
	
	private Integer age;
}
