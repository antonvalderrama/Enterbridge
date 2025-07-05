package com.enterbridge.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BrandCount {
	
	@Id
	private String brand;
	private int count;
}
