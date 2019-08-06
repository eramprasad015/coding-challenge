package com.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Entity
@Data
public class User {
	@Column(name="primarykey")
	private @Id @GeneratedValue Long primarykey;
	
	@OneToOne(cascade = {CascadeType.ALL}, fetch= FetchType.EAGER)
	@JoinColumn(name="name_id")
	//@JsonManagedReference
	private Name name;

	private String gender;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "id")
//	private Location location;
//	
//	private String email;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "id")
//	private Login login;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "id")
//	private DOB dob;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "id")
//	private Registered registered;
//	
//	private String phone;
//	
//	private String cell;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="user_identity",referencedColumnName = "id")
//	private UserIdentity id;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "id")
//	private Picture picture;
//	
//	private String nat;

}
