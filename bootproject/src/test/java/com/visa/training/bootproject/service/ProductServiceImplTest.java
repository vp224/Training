package com.visa.training.bootproject.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.visa.training.bootproject.dal.ProductRepository;
import com.visa.training.bootproject.domain.*;
public class ProductServiceImplTest {

	@Test
	public void addNewProduct_Returns_valid_id_when_value_greater_than_minvalue() {
		//arrange
		ProductServiceimpl impl = new ProductServiceimpl();
		Product toBeAdded = new Product("test",10000,2);
		
		
		Product added = new Product("test",10000,2);
		added.setId(1);
		
		ProductRepository mockDAO = Mockito.mock(ProductRepository.class);
		Mockito.when(mockDAO.save(toBeAdded)).thenReturn(added);
		impl.setDao(mockDAO);
		//act
		int id = impl.addNewProduct(toBeAdded);
		
		//assert
		assertTrue(id>0);
		
	}

}
