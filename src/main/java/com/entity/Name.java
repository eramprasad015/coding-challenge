package com.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
public class Name {
	@Column(name = "name_id")
	private @Id @GeneratedValue Long primarykey;
	private String title;
	private String first;
	private String last;

	//@JsonBackReference
	@JsonIgnore
	@OneToOne(mappedBy = "name", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private User user;

}
