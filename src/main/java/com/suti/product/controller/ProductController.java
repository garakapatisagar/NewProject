package com.suti.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suti.product.dto.ProductDto;
import com.suti.product.entity.Product;
import com.suti.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping
	public ResponseEntity<String> saveProduct(@Valid @RequestBody ProductDto dto)
	{
		String response = service.saveProduct(dto);
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return new ResponseEntity<List<Product>>(service.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") Long id)
	{
		return new ResponseEntity<Product>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateById(@PathVariable("id")Long id,@RequestBody ProductDto dto)
	{
		return new ResponseEntity<String>(service.updateById(id, dto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Long id)
	{
		return service.deleteById(id);
	}
}
