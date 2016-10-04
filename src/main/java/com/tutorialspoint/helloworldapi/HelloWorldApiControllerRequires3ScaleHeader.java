package com.tutorialspoint.helloworldapi;


import java.io.IOException;
import java.util.Enumeration;
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
public class HelloWorldApiControllerRequires3ScaleHeader {
		private final static String REQUIRED_HTTP_3SCALE_SECRET_TOKEN = "TomsSecretToken140701"; 
	
	   private static final String helloTemplate = "Hello, %s!";
	   private static final String goodbyeTemplate = "Bye, %s!";
    
	   private final AtomicLong counter = new AtomicLong();

		@Autowired
		private HttpServletRequest request;



		
	    @RequestMapping(value="/gethello-requires-3-scale-header", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Greeting gethello(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	String headerProxySecretToken = getThreeScaleProxySecretToken();
	    	
	    	verifySecretToken(headerProxySecretToken, response);
	    	
	    	Greeting g  = new Greeting(counter.incrementAndGet(), String.format(helloTemplate, name), headerProxySecretToken);
	    	
	    	
	    	
	    	return g;
	    }

	    @RequestMapping(value="/getgoodbye-requires-3-scale-header", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Greeting getgoodbye(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	
	    	String headerProxySecretToken = getThreeScaleProxySecretToken();
	    	
	    	verifySecretToken(headerProxySecretToken, response);
	    	
	    	Greeting g  = new Greeting(counter.incrementAndGet(), String.format(goodbyeTemplate, name), headerProxySecretToken);

	    	
	    	return g;
	    }
	    
	    private String getThreeScaleProxySecretToken(){
			System.out.println("******************************  NEW REQUEST  ******************************");

			
			String ret = "";
	    	Enumeration headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = request.getHeader(key);
				
				System.out.println(key+"::"+value);
				if("x-3scale-proxy-secret-token".equalsIgnoreCase(key)){
					ret = value;
				}
				
			}
			
			return ret;
	    }
	    
	    private void verifySecretToken(String headerProxySecretToken, HttpServletResponse response){
	    	try {
				if(!REQUIRED_HTTP_3SCALE_SECRET_TOKEN.equals(headerProxySecretToken)){
					response.sendError(HttpServletResponse.SC_FORBIDDEN, "AdditionalInformationIfAvailable");	
				}
	    		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
}
