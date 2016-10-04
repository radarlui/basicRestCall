package com.tutorialspoint.webhook;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WebhookController {


    @RequestMapping(value="/post-webhook-xmlstring", method=RequestMethod.POST, headers="Accept=application/xml") 
    public @ResponseBody String postWebHook(
            @RequestBody String event,
            HttpServletRequest request, 
            HttpServletResponse response) {

    	System.out.println("\n received POST event string..............\n\n"+event);
    	System.out.println("\n\n\n");
    	
    	System.out.println("\n parameters sent to webhook ");
		
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String key = (String) paramNames.nextElement();
			String value = request.getParameter(key);
			
			System.out.println(key+"::"+value);

		}
   	
    	return event;
    	
    }

    @RequestMapping(value="/post-webhook", method=RequestMethod.POST, headers="Accept=application/xml") 
        public @ResponseBody Event postWebHook(
                @RequestBody Event event,
                HttpServletRequest request, 
                HttpServletResponse response) {
        
    	System.out.println("\n received POST event .............."+event);
    	System.out.println("headers sent to webhook ");
		
		String ret = "";
    	Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			
			System.out.println(key+"::"+value);

		}
    	System.out.println("\n\n\n");

    	System.out.println("\n parameters sent to webhook ");
		
		ret = "";
    	Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String key = (String) paramNames.nextElement();
			String value = request.getParameter(key);
			
			System.out.println(key+"::"+value);

		}
    	System.out.println("\n\n\n");

    	//TO TEST REJECTION: response.setStatus(403);
    	return event;
    }


    @RequestMapping(value="/get-webhook", method=RequestMethod.GET, headers="Accept=application/xml") 
    public @ResponseBody Event getWebHook(
            @RequestBody Event event,
            HttpServletRequest request, 
            HttpServletResponse response) {
        
    	System.out.println("/n received GET event .............."+event);
    	
    	return event;
    }


}
