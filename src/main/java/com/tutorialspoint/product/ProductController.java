package com.tutorialspoint.product;

import com.tutorialspoint.model.Geography;
import com.tutorialspoint.model.GenericResult;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tutorialspoint.model.Product;

@Controller
public class ProductController {
		private Map<Integer, Product> products;
		private int maxProduct;
	    public ProductController() {
			super();
			products = new HashMap<Integer, Product>();
			for(int i = 1; i< 6; i++){
				Product product = new Product(i, "10000"+i, "Product 10000"+i);
				products.put(i, product);
				maxProduct=i;
			}
		}


		@RequestMapping(value="/product", method=RequestMethod.POST, produces="application/json", consumes="application/json") 
	    public @ResponseBody Product postProduct(@RequestBody Product product) {
	        
			product.setId(++maxProduct);
			products.put(maxProduct, product);
	    	return product;
	    }



		@RequestMapping(value="/product/{id}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Product getProduct(@PathVariable("id") Integer id, HttpServletRequest request) {

			System.out.println("**********Headers");
			Enumeration headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = request.getHeader(key);
				
				System.out.println(key+"::"+value);
				
			}
			

			
			
	    	if(products.get(id)!=null){
	    		return products.get(id);
	    	}
	    	
	    	return new Product();
	    }


		@RequestMapping(value="/product/{id}", method=RequestMethod.DELETE, produces="application/json") 
	    public @ResponseBody GenericResult deleteProduct(@PathVariable("id") Integer id) {
	        
	    	if(products.containsKey(id) && products.remove(id)!=null){
	    		return new GenericResult("Product "+id+" successfully deleted");
	    	}
	    	
	    	return new GenericResult("Product "+id+" NOT FOUND");
	    }
		
		
		
	    @RequestMapping(value="/post/xml/product", method=RequestMethod.POST, 
	    		produces="application/xml", consumes="application/xml") 
	    public @ResponseBody Product postXMLRequestBody(@RequestBody Product product) {
	        
	    	System.out.println("**************************************** post json request body ");
	    	product.setId(++maxProduct);
			products.put(maxProduct, product);
	    	return product;
	    }


	    @RequestMapping(value="/geographicData/{geography}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Geography getGeographicData(@PathVariable("geography") String geography) {
	        	    
	    	return new Geography(geography);
	    	
	    }

		
}
