package com.stockcompany.springapp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stockcompany.springapp.domain.Product;

public class SimpleProductTest {

	SimpleProductManager productManager;
    private List<Product> products;
    
    private static int PRODUCT_COUNT = 2;
    private static Double CHAIR_PRICE = new Double(20.50);
    private static String CHAIR_DESCRIPTION = "Chair";
    private static String TABLE_DESCRIPTION = "Table";
    private static Double TABLE_PRICE = new Double(150.10); 
    private static int POSITIVE_PRICE_INCREASE = 10; 
	
	@Before
	public void setUp() throws Exception {
		 productManager = new SimpleProductManager();
	        products = new ArrayList<Product>();
	        
	        // stub up a list of products
	        Product product = new Product();
	        product.setDescription("Chair");
	        product.setPrice(CHAIR_PRICE);
	        products.add(product);
	        
	        product = new Product();
	        product.setDescription("Table");
	        product.setPrice(TABLE_PRICE);
	        products.add(product);
	        
	        productManager.setProducts(products);
	}

	@Test
	public void testIncreasePrice() {

	}
	
	@Test
	public void testGetProductsWithNoProducts() {
		SimpleProductManager productManager = new SimpleProductManager();
		assertNull(productManager.getAllProducts());
	}
	
	@Test
	public void testSetProducts() {
		SimpleProductManager productManager = new SimpleProductManager();
		List<Product> productsEmptyList = new ArrayList<Product>();
		productManager.setProducts(productsEmptyList);
		assertNotNull(productManager.getAllProducts());
	}
	
	@Test
    public void testGetProducts() {
        List<Product> products = productManager.getAllProducts();
        assertNotNull(products);        
        assertEquals(PRODUCT_COUNT, productManager.getAllProducts().size());
    
        Product product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDescription());
        assertEquals(CHAIR_PRICE, product.getPrice());
        
        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDescription());
        assertEquals(TABLE_PRICE, product.getPrice());      
    }
	
	 @Test
	    public void testIncreasePriceWithNullListOfProducts() {
	        try {
	            productManager = new SimpleProductManager();
	            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
	        }
	        catch(NullPointerException ex) {
	            fail("Products list is null.");
	        }
	    }

	    @Test
	    public void testIncreasePriceWithEmptyListOfProducts() {
	        try {
	            productManager = new SimpleProductManager();
	            productManager.setProducts(new ArrayList<Product>());
	            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
	        }
	        catch(Exception ex) {
	            fail("Products list is empty.");
	        }           
	    }

}
