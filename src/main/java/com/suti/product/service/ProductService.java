package com.suti.product.service;

import java.util.List;

import com.suti.product.dto.ProductDto;
import com.suti.product.entity.Product;

public interface ProductService {

	String saveProduct(ProductDto productDto);
	
	List<Product> getAllProducts();
	
	Product getById(Long id);
	
	String updateById(Long id,ProductDto dto);
	
	String deleteById(Long id);
}
