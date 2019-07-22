package com;

import javax.persistence.GeneratedValue;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Name {
	@Column(unique=true, nullable=false, updatable=false)
	private @Id @GeneratedValue Long id;
	private String title;
	private String first;
	private String last;

}
