package com.enterbridge.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long productKey;
	private String retailer;
	private String brand;
	private String model;
	private String productName;
	private String productDescription;
	private Double price;
	
	
}
