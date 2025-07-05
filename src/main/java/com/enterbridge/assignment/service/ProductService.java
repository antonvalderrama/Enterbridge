package com.enterbridge.assignment.service;

import java.util.List;

import com.enterbridge.assignment.entity.BrandCount;
import com.enterbridge.assignment.entity.Product;

public interface ProductService {

	public List<Product> getProducts();

	public void addProduct(Product product);

	public Product getProductDetails(Long productKey);
	
	public List<BrandCount> getBrandCount();
	
	public BrandCount getBrandCount(String brand);

}
