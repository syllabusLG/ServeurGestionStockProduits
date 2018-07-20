package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.ICrudService;

@RestController
@RequestMapping(value="/crud_user")
public class CrudUserController {

	@Autowired
	private ICrudService<User, Long> crudUserService;
	
	@GetMapping
	public List<User> getUsers(){
		return crudUserService.getAll();
	}
	@PostMapping
	public void addUser(@RequestBody User user) {
		crudUserService.add(user);
	}
	@PutMapping
	public void updateUser(@RequestBody User user) {
		crudUserService.update(user);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		crudUserService.delete(id);
	}
}
