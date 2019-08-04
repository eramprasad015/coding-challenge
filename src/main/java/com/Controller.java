package com;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
class Controller {


	  private final UserRepository repository;

	  Controller(UserRepository repository) {
	    this.repository = repository;
	  }

	  // Aggregate root

	  @GetMapping("/user")
	  List<User> all() {
	    return repository.findAll();
	  }

	  @PostMapping("/user")
	  User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	  }
	  
	  @PostMapping("/users")
	  List<User> newUser(@RequestBody UserWrapper userWrapper) {
		List<User> newUserList = new ArrayList<User>();
		for(User u : userWrapper.getUsers()) newUserList.add(repository.save(u));
		return newUserList;
	  }

	  // Single item

	  @GetMapping("/user/{id}")
	  User one(@PathVariable Long id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find that user."));
	  }

	  @PutMapping("/user/{id}")
	  User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(User -> {
	        return repository.save(User);
	      })
	      .orElseGet(() -> {
	        return repository.save(newUser);
	      });
	  }

//	  @DeleteMapping("/user/{id}")
//	  void deleteUser(@PathVariable Long id) {
//	    repository.deleteById(id);
//	  }
}
