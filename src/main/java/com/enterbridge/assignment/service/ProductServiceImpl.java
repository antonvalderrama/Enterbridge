package com.enterbridge.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterbridge.assignment.entity.BrandCount;
import com.enterbridge.assignment.entity.Product;
import com.enterbridge.assignment.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;
	
	@Override
	public List<Product> getProducts() {
		return this.repository.findAll();
	}

	@Override
	public void addProduct(Product product) {
		this.repository.save(product);
		
	}
	

	@Override
	public Product getProductDetails(Long productKey) {
		return this.repository.getReferenceById(productKey);
	}

	@Override
	public List<BrandCount> getBrandCount() {
		return this.repository.getBrandCount();
	}
	
	@Override
	public BrandCount getBrandCount(String brand) {
		return this.repository.getBrandCount(brand);
	}


}
