package com.stockcompany.springapp.service;

import java.util.List;

import com.stockcompany.springapp.domain.Product;

public interface ProductManager {

	public void increasePrice(int percentage);
	
	public List<Product> getAllProducts();

}
