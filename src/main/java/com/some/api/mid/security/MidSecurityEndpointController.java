package com.some.api.mid.security;


import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tutorialspoint.model.Greeting;

@Controller
public class MidSecurityEndpointController {
    
	   private final AtomicLong counter = new AtomicLong();

		@Autowired
		private HttpServletRequest request;



		
	    @RequestMapping(value="/get-mid-security-endpoint-1", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Greeting getMidSecurityEndpointOne(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	Greeting g  = new Greeting(counter.incrementAndGet(), "get-mid-security-endpoint-1:"+name, "Some Header");
	    		    	    	
	    	return g;
	    }


		
	    @RequestMapping(value="/get-mid-security-endpoint-2", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Greeting getMidSecurityEndpointTwo(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	Greeting g  = new Greeting(counter.incrementAndGet(), "get-mid-security-endpoint-2:"+name, "Some Header");
	    		    	    	
	    	return g;
	    }

	    
		
	    @RequestMapping(value="/get-mid-security-endpoint-3", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Greeting getMidSecurityEndpointThree(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	Greeting g  = new Greeting(counter.incrementAndGet(), "get-mid-security-endpoint-3:"+name, "Some Header");
	    		    	    	
	    	return g;
	    }

	    
	    @RequestMapping(value="/post-mid-security-endpoint-1", method=RequestMethod.POST, produces="application/json") 
	    public @ResponseBody Greeting postMidSecurityEndpointOne(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	Greeting g  = new Greeting(counter.incrementAndGet(), "post-mid-security-endpoint-1:"+name, "Some Header");
	    	
	    	return g;
	    }

	    
	    @RequestMapping(value="/post-mid-security-endpoint-2", method=RequestMethod.POST, produces="application/json") 
	    public @ResponseBody Greeting postMidSecurityEndpointTwo(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	Greeting g  = new Greeting(counter.incrementAndGet(), "post-mid-security-endpoint-2:"+name, "Some Header");
	    	
	    	return g;
	    }
		
	    
	    @RequestMapping(value="/post-mid-security-endpoint-3", method=RequestMethod.POST, produces="application/json") 
	    public @ResponseBody Greeting postMidSecurityEndpointThree(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	Greeting g  = new Greeting(counter.incrementAndGet(), "post-mid-security-endpoint-3:"+name, "Some Header");
	    	
	    	return g;
	    }
		
	    
}
