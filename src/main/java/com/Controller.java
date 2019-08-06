package com;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.entity.Name;
import com.entity.User;
import com.entity.UserWrapper;
import com.repository.UserRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
class Controller {


	  private final UserRepository repository;

	  Controller(UserRepository repository) {
	    this.repository = repository;
	  }

	  @GetMapping("/user")
	  Resources<Resource<User>> all() {
		List<Resource<User>> users = repository.findAll().stream()
				.map(user -> new Resource<>(user,
						linkTo(methodOn(Controller.class).one(user.getPrimarykey())).withSelfRel(),
						linkTo(methodOn(Controller.class).all()).withRel("users")))
				.collect(Collectors.toList());

		return new Resources<>(users,
				linkTo(methodOn(Controller.class).all()).withSelfRel());
	  }

	  @PostMapping("/user")
	  User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	  }
	  
//	  @PostMapping("/users")
//	  List<User> newUser(@RequestBody UserWrapper userWrapper) {
//		List<User> newUserList = new ArrayList<User>();
//		for(User u : userWrapper.getUsers()) newUserList.add(repository.save(u));
//		return newUserList;
//	  }

	  // Single item

	  @GetMapping("/user/{id}")
	  User one(@PathVariable Long id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find that user."));
	  }

	  @PutMapping("/user/{id}")
	  User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

//	    return repository.findById(id)
//	      .map(User -> {
//	        return repository.save(User);
//	      })
//	      .orElseGet(() -> {
//	        return repository.save(newUser);
//	      });

		  return repository.findById(id)
				  .map(user -> {
					  user.setName(newUser.getName());
					  user.setGender(newUser.getGender());
					  return repository.save(user);
				  })
				  .orElseGet(() -> {
					  //newUser.setId(id);
					  return repository.save(newUser);
				  });
	  }

	  @DeleteMapping("/user/{id}")
	  void deleteUser(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
}
