package com.tutorialspoint.helloworldapi;


import java.net.URI;
import java.util.Collections;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutorialspoint.model.Greeting;
import com.tutorialspoint.model.RequestItem;

@Controller
public class HelloWorldApiController {
	   private static final String helloTemplate = "Hello, %s!";
	   private static final String goodbyeTemplate = "Bye, %s!";
    
	   private final AtomicLong counter = new AtomicLong();

		@Autowired
		private HttpServletRequest request;



		
	    @RequestMapping(value="/gethello-query-param", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Greeting gethelloqueryparam(
	    		@RequestParam(value="user_key", required=false, defaultValue="") String user_key,
	    		@RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	Greeting g  = new Greeting(counter.incrementAndGet(), String.format(helloTemplate, name), "method was user_key");
	    	
	    	return g;
	    }

		
	    @RequestMapping(value="/gethello", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Greeting gethello(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	String headerProxySecretToken = getThreeScaleProxySecretToken("GET");
	    	
	    	
	    	Greeting g  = new Greeting(counter.incrementAndGet(), String.format(helloTemplate, name), headerProxySecretToken);
	    	
	    	
	    	
	    	return g;
	    }

	
	    @RequestMapping(value="/posthello", method=RequestMethod.POST, produces="application/json") 
	    public @ResponseBody Greeting posthello(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	System.out.println("****************************************posthellon name is: "+name);

	    	
	    	
	    	String headerProxySecretToken = getThreeScaleProxySecretToken("POST");
	    	
	    	Greeting g  = new Greeting(counter.incrementAndGet(), String.format(helloTemplate, name), headerProxySecretToken);
	    	
	    	
	    	
	    	return g;
	    }


		
	    @RequestMapping(value="/post/a/long/path", method=RequestMethod.POST, produces="application/json") 
	    public @ResponseBody Greeting postALongPath(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	System.out.println("**************************************** post a long path, name is: "+name);

	    	
	    	
	    	String headerProxySecretToken = getThreeScaleProxySecretToken("POST");
	    	
	    	Greeting g  = new Greeting(counter.incrementAndGet(), String.format(helloTemplate, name), headerProxySecretToken);
	    	
	    	return g;
	    }


		
	    @RequestMapping(value="/post/json/request/body", method=RequestMethod.POST, 
	    		produces="application/json") 
	    public @ResponseBody Greeting postJsonRequestBody(@RequestBody Greeting greeting) {
	        
	    	System.out.println("**************************************** post json request body ");

	    	
	    	Greeting returnedGreeting = new Greeting(greeting.getId()+1, 
	    			greeting.getContent()+"X", 
	    			greeting.getHeader()+"Y"); 

	    	
	    	return returnedGreeting;
	    }


		
	    @RequestMapping(value="/post/string/body", method=RequestMethod.POST, 
	    		produces="application/json") 
	    public @ResponseBody String postStringBody(@RequestBody String stringBody) {
	        
	    	System.out.println("**************************************** post json request body ");

	    	String newStringBody = "You posted\n"+stringBody;
	    	
	    	return newStringBody;
	    }

	    @RequestMapping (value="/post/a/file", method = RequestMethod.POST)
	    Greeting postFile(@RequestParam MultipartFile fileName) throws
	                  Throwable {
	        // write it
	        byte bytesForProfilePhoto[] = FileCopyUtils.copyToByteArray(fileName.getInputStream());
	        
	        String result = new String(bytesForProfilePhoto);
	        result ="<<<<<<<<<</n"+result+">>>>>>>>>>>\n";
	        
	        
	        URI uriOfUser = ServletUriComponentsBuilder.fromCurrentContextPath()
	            .pathSegment( "/users/{user}" )
	            .buildAndExpand(Collections.singletonMap("user", "Tom"))
	            .toUri();
	        
	        Greeting returnedGreeting = new Greeting(1, 
	    			result, 
	    			uriOfUser.toString()); 

	        
	        return returnedGreeting;
	    }
	    
	    @RequestMapping(value="/getgoodbye", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Greeting getgoodbye(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	
	    	String headerProxySecretToken = getThreeScaleProxySecretToken("GET");
	    	
	    	
	    	Greeting g  = new Greeting(counter.incrementAndGet(), String.format(goodbyeTemplate, name), headerProxySecretToken);

	    	
	    	return g;
	    }
	    
	    

	    @RequestMapping(value="/getaccuracy", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody Integer getaccuracy() {
	        
	    	getThreeScaleProxySecretToken("GET");
	    	
	    	double dbl = Math.random();
	    	Integer ret = (int) (dbl*100);
	    	
	    	return ret;
	    	
	    }
	    

	    @RequestMapping(value="/endpoint", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody RequestItem getendpoint() {
	        
	    	return new RequestItem("Endpoint Only", "no params");
	    	
	    }

	    @RequestMapping(value="/endpoint/{variable}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody RequestItem getendpointWithVariable(@PathVariable("variable") String variable) {
	        
	    	return new RequestItem("Endpoint with variable", variable);
	    	
	    }

	    
	    
	    
	    //***************************************  XML  ***********************************************		
	    @RequestMapping(value="/gethello-xml", method=RequestMethod.GET, produces="application/xml") 
	    public @ResponseBody Greeting gethelloXML(
	            @RequestParam(value="name", required=false, defaultValue="3Scale User") String name,
	            HttpServletResponse response) {
	        
	    	String headerProxySecretToken = getThreeScaleProxySecretToken("GET");
	    	
	    	
	    	Greeting g  = new Greeting(counter.incrementAndGet(), String.format(helloTemplate, name), headerProxySecretToken);
	    	
	    	return g;
	    }


		
	    @RequestMapping(value="/post/xml/request/body", method=RequestMethod.POST, 
	    		produces="application/xml", consumes="application/xml") 
	    public @ResponseBody Greeting postXMLRequestBody(@RequestBody Greeting greeting) {
	        
	    	System.out.println("**************************************** post json request body ");

	    	
	    	Greeting returnedGreeting = new Greeting(greeting.getId()+1, 
	    			greeting.getContent()+"X", 
	    			greeting.getHeader()+"Y"); 

	    	
	    	return returnedGreeting;
	    }


	    
	    
	    private String getThreeScaleProxySecretToken(String type){
	    	System.out.println("******************************  NEW "+type+" REQUEST  ******************************");

			
			String ret = "";
	    	Enumeration headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = request.getHeader(key);
				
				System.out.println(key+"::"+value);

			}
			
			System.out.println("/n/n ----------- Params  ----------- ");

			
	    	Enumeration params = request.getParameterNames();
			while (params.hasMoreElements()) {
				String key = (String) params.nextElement();
				String value = request.getParameter(key);
				
				System.out.println(key+"::"+value);

			}
			
			return ret;
	    }
	    
	    
}
