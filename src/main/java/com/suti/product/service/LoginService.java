package com.suti.product.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.suti.product.dto.LoginRequest;
import com.suti.product.dto.LoginResponse;
import com.suti.product.dto.RegisterUser;
import com.suti.product.entity.User;
import com.suti.product.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class LoginService {

	
	private UserRepository repository;
	
	public LoginService(UserRepository repository)
	{
		this.repository=repository;
	}
	
	public LoginResponse loginService(LoginRequest request) {
		
		User user=repository.findByEmail(request.getEmail()).orElseThrow();
		
		if(!user.getPassword().equals(request.getPassword()))
		{
			throw new RuntimeException("Invalid password");
		}
		
		String token=UUID.randomUUID().toString();
		
		return new LoginResponse(token);
	}

	@Transactional
	public User createUser(RegisterUser user) {
          
		User newuser=new User();
		User saveduser=null;
		try {
			newuser.setEmail(user.getEmail());
			newuser.setName(user.getName());
			newuser.setPassword(user.getPassword());
			
			 saveduser = repository.save(newuser);
			}catch(DataIntegrityViolationException ex)
			{
				throw new RuntimeException("Duplicate users not allowed");
			}
		return saveduser;
	}



	public List<User> findAllUsers() {
		     
		return repository.findAll();
	}

	public User findById(Integer id) {
		
		return repository.findById(id).get();
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}