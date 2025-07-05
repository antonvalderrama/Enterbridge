package com.enterbridge.assignment.service;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.enterbridge.assignment.entity.BrandCount;
import com.enterbridge.assignment.entity.Product;
import com.enterbridge.assignment.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestProductServiceImpl {
	
	@InjectMocks
	private ProductServiceImpl classUnderTest;
	
	@Mock
	private ProductRepository repository;
	
	@Test
	public void testGetProductsReturnsFindAll() {
		
		List<Product> aDifferentList = mock(List.class);
		List<Product> expectedList = mock(List.class);
		
		//mock repository.findAll() and have it return an expected list
		when(this.repository.findAll()).thenReturn(expectedList);
		
		List<Product> actualList = classUnderTest.getProducts();
		
		//confirm that the expected list was returned and not just any other list
		assertThat(actualList, is(expectedList));
		assertThat(actualList, not(aDifferentList));
		
		//confirm that repository.findAll() is called only once
		verify(this.repository, times(1)).findAll();
	}
	
	@Test
	public void testAddProductCallsSave() {
		
		Product product = mock(Product.class);
		
		this.classUnderTest.addProduct(product);
		
		//Confirm that repository.save() is called only once
		verify(this.repository, times(1)).save(product);
	}
	
	@Test
	public void testGetProductDetailsCallsGetReferenceById() {
		
		long productKey = 123456789l;
		long anotherKey = 987654321l;
		
		Product expectedProduct = mock(Product.class);
		Product anotherProduct = mock(Product.class);
		
		when(this.repository.getReferenceById(productKey)).thenReturn(expectedProduct);
		
		Product actualProduct = this.classUnderTest.getProductDetails(productKey);
		
		
		assertThat(actualProduct, is(expectedProduct));
		assertThat(actualProduct, not(anotherProduct));
		
		verify(this.repository, times(1)).getReferenceById(productKey);
		verify(this.repository, never()).getReferenceById(anotherKey);
		
	}
	
	@Test
	public void testGetBrandCountReturnsList() {
		
		List<BrandCount> expectedList = mock(List.class);
		when(this.repository.getBrandCount()).thenReturn(expectedList);
		
		List<BrandCount>  actualList = this.classUnderTest.getBrandCount();
		
		//confirm that the returned list is as expected
		assertThat(actualList, is(expectedList));
		
		//confirm that repository.getBrandSummaryCount() is called only once.
		verify(this.repository, times(1)).getBrandCount();
	}
	
	@Test
	public void testGetBrandCountReturnsBrandCount() {
		
		BrandCount expected = mock(BrandCount.class);
		String brand = "brand";
		when(this.repository.getBrandCount(brand)).thenReturn(expected);
		
		BrandCount actual = this.classUnderTest.getBrandCount(brand);
		
		//confirm that the returned object is as expected
		assertThat(actual, is(expected));
		
		//confirm that repository.getBrandCountBrand(brand) is called only once
		verify(this.repository, times(1)).getBrandCount(brand);
		
		//confirm that repository.getBrandCountBrand(brand) is called only with the passed "brand" parameter
		verify(this.repository, times(1)).getBrandCount(anyString());
	}
}
