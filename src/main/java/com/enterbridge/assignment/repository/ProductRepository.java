package com.enterbridge.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enterbridge.assignment.entity.BrandCount;
import com.enterbridge.assignment.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value = "SELECT p.brand, count(p) FROM product p GROUP BY p.brand", nativeQuery = true)
	public List<BrandCount> getBrandCount();
	
	@Query(value = "SELECT p.brand, count(p) FROM product p WHERE p.brand = :brand GROUP BY p.brand", nativeQuery = true)
	public BrandCount getBrandCount(@Param("brand") String brand);
}
