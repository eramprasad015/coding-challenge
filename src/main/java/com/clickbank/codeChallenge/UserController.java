package com.clickbank.codeChallenge;


import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@RestController()
public class UserController {
	
	
	private RestTemplate template = new RestTemplate();
	
	@GetMapping("/user")
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<JSONObject>> getUsers() {
		
		LinkedHashMap<JSONObject, JSONObject> result = (LinkedHashMap<JSONObject, JSONObject>) template.getForObject("https://randomuser.me/api/?results=20", Object.class);
		return new ResponseEntity(result.get("results"), HttpStatus.OK);
		
	}

	@GetMapping("/user/{uuid}")
	public ResponseEntity<List<JSONObject>> getUserById(@PathVariable String uuid) {
		
		LinkedHashMap<JSONObject, JSONObject> result = (LinkedHashMap<JSONObject, JSONObject>) template.getForObject("https://randomuser.me/api/?uuid=" + uuid, Object.class);
		return new ResponseEntity(result.get("results"), HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity saveUser(@RequestBody JSONObject jsonObject ) {
		JSONObject result = template.postForObject("https://randomuser.me/api/", jsonObject, JSONObject.class);
		return new ResponseEntity(result, HttpStatus.OK);

	}
	
	@PutMapping("/user/{uuid}")
	public ResponseEntity updateUser(@RequestBody JSONObject jsonObject, @PathVariable String uuid ) {
		JSONObject result = template.postForObject("https://randomuser.me/api/", jsonObject, JSONObject.class);
		return new ResponseEntity(result, HttpStatus.OK);

	}
	

	
}
