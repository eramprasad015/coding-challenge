package com;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
@Entity
public class Name {
	@Column(name = "name_id")
	private @Id @GeneratedValue Long primarykey;
	private String title;
	private String first;
	private String last;

	@JsonBackReference
	@OneToOne(mappedBy = "name")
	private User user;

}
