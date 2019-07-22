package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Login {
	@Column(unique=true, nullable=false, updatable=false)
	private @Id @GeneratedValue Long id;
	private String uuid;
	private String username;
	private String password;
	private String salt;
	private String md5;
	private String sha1;
	private String sha256;
}
