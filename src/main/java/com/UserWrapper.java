package com;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class UserWrapper {

	private List<User> users = new ArrayList<User>();
}
