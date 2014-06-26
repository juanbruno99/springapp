package com.stockcompany.springapp.web;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.stockcompany.springapp.service.ProductManager;
import com.stockcompany.springapp.service.SimpleProductManager;

public class InventoryControllerTest {
	
	ProductManager productManager; 
	
	@Before
	public void setUp() {
		productManager = new SimpleProductManager();
	}

	@Test
	public void testHandleRequestView() throws Exception {
		InventoryController controller = new InventoryController();
		controller.setProductManager(productManager);
		ModelAndView modelAndView = controller.handleRequest(null, null);
		//asserts view name from modelAndView returned, view through ViewResolver
        assertEquals("hello", modelAndView.getViewName());
        //asserts there's a model being returned as well
        assertNotNull(modelAndView.getModel());
        //asserts content from model
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("myModel");
        String nowValue = (String) modelMap.get("now"); 
        assertNotNull(nowValue);
        assertNull(modelMap.get("products"));
	}
}
