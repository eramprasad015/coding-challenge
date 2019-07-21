package com;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Controller {


	  private final UserRepository repository;

	  Controller(UserRepository repository) {
	    this.repository = repository;
	  }

	  // Aggregate root

	  @GetMapping("/Users")
	  List<User> all() {
	    return repository.findAll();
	  }

	  @PostMapping("/Users")
	  User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	  }

	  // Single item

	  @GetMapping("/Users/{id}")
	  User one(@PathVariable Long id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new UserNotFoundException(id));
	  }

	  @PutMapping("/Users/{id}")
	  User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(User -> {
	        User.setName(newUser.getName());
	        return repository.save(User);
	      })
	      .orElseGet(() -> {
	        newUser.setId(id);
	        return repository.save(newUser);
	      });
	  }

	  @DeleteMapping("/Users/{id}")
	  void deleteUser(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
}
