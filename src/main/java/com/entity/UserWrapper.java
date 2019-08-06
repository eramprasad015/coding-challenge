package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import lombok.Data;

@Data
public class UserWrapper {

	private List<User> users = new ArrayList<User>();
}
