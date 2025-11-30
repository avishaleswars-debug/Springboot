package com.code.springbootdemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.springbootdemo.entity.UserEntity;
//import com.code.springbootdemo.model.User;
import com.code.springbootdemo.repository.UserRepository;

@RestController
@RequestMapping("/hello")
public class Usercontroller {
	@Autowired
	private UserRepository repo;
//@GetMapping
//public String get() {
//	return "hello";
//}
//	@GetMapping("/user")
	@GetMapping()
	public List<UserEntity> getuser() {
	//return Arrays.asList(new User(1L,"ajay","ajay@gmail.com"),new User(2L,"vishal","vishal@gmail.com"));
		return repo.findAll();
	}
	@PostMapping
	public UserEntity createuser(@RequestBody UserEntity user){
return repo.save(user); 
	}
	@GetMapping("/{id}")
	public Optional<UserEntity> getUserBody(@PathVariable Long id) {
	return repo.findById(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUser(
	        @PathVariable Long id,
	        @RequestBody UserEntity user) {

	    UserEntity userdata = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    userdata.setEmail(user.getEmail());
	    userdata.setName(user.getName());

	    return ResponseEntity.ok(repo.save(userdata));
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteuser(@PathVariable Long id) {
		UserEntity user=repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		repo.delete(user);
		return ResponseEntity.ok().build();
		
	}
}

