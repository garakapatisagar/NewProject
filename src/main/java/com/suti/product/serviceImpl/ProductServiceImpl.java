package com.suti.product.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suti.product.dto.ProductDto;
import com.suti.product.entity.Product;
import com.suti.product.repo.ProductRepository;
import com.suti.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repository;
	
	@Override
	public String saveProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		Product p=new Product();
		p.setName(productDto.getName());
		p.setCategory(productDto.getCategory());
		p.setPrice(productDto.getPrice());
		p.setQuantity(productDto.getQuantity());
		
		Product product = repository.save(p);
		if(product==null)
		{
			return "There was a problem in while saving data";
		}
		return "Product saved successfully";
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		return repository.findAll();
	}

	@Override
	public Product getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> product = repository.findById(id);
		if(product.isEmpty())
		{
			return product.orElseThrow(()-> new RuntimeException("Product Not Found"));
		}
		return product.get();
	}

	@Override
	public String deleteById(Long id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
		return "product deleted successfully";
	}

	@Override
	public String updateById(Long id, ProductDto dto) {
		// TODO Auto-generated method stub
		Optional<Product> p = repository.findById(id);
		if(p.isPresent())
		{
			Product prod=p.get();
			prod.setName(dto.getName());
			prod.setCategory(dto.getCategory());
			prod.setPrice(dto.getPrice());
			prod.setQuantity(dto.getQuantity());
			
			Product p1=repository.save(prod);
			if(p1==null)
			{
				return "There was a problem in update";
			}
			
		}
		return "Data Updated successfully";
	}

}
