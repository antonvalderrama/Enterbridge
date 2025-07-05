package com.enterbridge.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterbridge.assignment.entity.BrandCount;
import com.enterbridge.assignment.entity.Product;
import com.enterbridge.assignment.service.ProductService;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	/**
	 * GET /products
	 * List all products
	 * @return List of products
	 */
	@GetMapping("/products")
	public List<Product> getProducts(){
		
		return this.service.getProducts();
	}
	
	/**
	 * GET /products/{productKey}
	 * Get full product details
	 * @param productKey
	 * @return product
	 */
	@GetMapping("/products/{productKey}")
	public Product getProductDetails(@PathVariable Long productKey){
		
		return this.service.getProductDetails(productKey);
	}
	
	/**
	 * POST /products
	 * Add a new product
	 * @param product
	 */
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		
		this.service.addProduct(product);
		
		return product;
	}
	
	@GetMapping("/products/brand-summary")
	public List<BrandCount> getBrandCount() {
		return this.service.getBrandCount();
	}
	
	@GetMapping("/products/{brand}/count")
	public BrandCount getBrandCount(@PathVariable String brand) {
		return this.service.getBrandCount(brand);
	}
	
	
	
}
