package com.suti.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suti.product.dto.LoginRequest;
import com.suti.product.dto.LoginResponse;
import com.suti.product.dto.RegisterUser;
import com.suti.product.entity.User;
import com.suti.product.service.LoginService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	private LoginService service;
	
	public LoginController(LoginService service)
	{
		this.service=service;
	}
	
	@PostMapping("/login")
	public LoginResponse login(@Valid @RequestBody LoginRequest request)
	{
		System.out.println("commiting from git repository");
		return service.loginService(request);
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterUser user)
	{
		System.out.println("commitiing from local develop branch repositoty");
		return new ResponseEntity<User>(service.createUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{

		return service.findAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getById(@PathVariable Integer id)
	{

		return service.findById(id);
	}
	
	//2 nd task
	@GetMapping("/users/getAll")
	public List<User> getAlUsers()
	{

		return service.findAllUsers();
	}
	
}
