package com.suti.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDto {

	@NotBlank(message="name is required")
	private String name;
	
	@NotBlank(message="category is required")
	private String category;
	
	@Min(value=1,message="price must be greater than 0")
	private double price;
	
	@Min(value=1,message="quantity must be greater than 0")
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
