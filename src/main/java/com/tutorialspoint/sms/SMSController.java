package com.tutorialspoint.sms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tutorialspoint.model.GenericResult;
import com.tutorialspoint.model.SMS;

@Controller
public class SMSController {
		private Map<Integer, SMS> smss;
		private int maxSMS;
	    public SMSController() {
			super();
			smss = new HashMap<Integer, SMS>();
			for(int i = 1; i< 4; i++){
				long ts = System.currentTimeMillis();
				SMS sms = new SMS(i, "44750088776"+i, "44750089776"+(i+4), "Some random SMS Character text "+i);
				smss.put(i, sms);
				maxSMS=i;
			}
		}
	    
	    
		@RequestMapping(value="/sms/v2/{id}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody SMS getSMS(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
			
			SMS toReturn = null;
	    	if(smss.get(id)!=null){
	    		response.setStatus(200);
	    		toReturn =  smss.get(id);
	    		toReturn.setTimeStamp(""+ System.currentTimeMillis());
	    		return toReturn;
	    	}
	    	
	    	response.setStatus(404);
	    	return null;
	    	
	    }
		
		 
		@RequestMapping(value="/sms/v2", method=RequestMethod.POST, produces="application/json", consumes="application/json") 
	    public @ResponseBody SMS postProduct(@RequestBody SMS sms, HttpServletResponse response) {
	        
			response.setStatus(201);
			sms.setId(++maxSMS);
			smss.put(maxSMS, sms);
	    	return sms;
	    	
	    }
		
		
		@RequestMapping(value="/sms/v2/{id}", method=RequestMethod.PUT, produces="application/json", consumes="application/json") 
	    public @ResponseBody SMS putProduct(@PathVariable("id") Integer id, @RequestBody SMS sms, HttpServletResponse response) {
	        
			response.setStatus(204);
			sms.setId(id);
			smss.put(id, sms);
	    	return sms;
	    	
	    }
		
		
		@RequestMapping(value="/sms/v2/{id}", method=RequestMethod.DELETE, produces="application/json") 
	    public @ResponseBody GenericResult deleteProduct(@PathVariable("id") Integer id, HttpServletResponse response) {
	        
	    	if(smss.containsKey(id) && smss.remove(id)!=null){
	    		response.setStatus(204);
	    		return new GenericResult("SMS "+id+" successfully deleted");
	    	}
	    	
	    	response.setStatus(404);
	    	return new GenericResult("SMS "+id+" NOT FOUND");
	    	
	    }
		
		
		@RequestMapping(value="/sms/v2", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody List<SMS> getAllSMSs(HttpServletRequest request, HttpServletResponse response) {
			
	    	return new ArrayList<SMS>(smss.values());
	    	
	    }
		
		@RequestMapping(value="/smsbulk/v2", method=RequestMethod.POST, produces="application/json") 
	    public @ResponseBody List<SMS> postSmsBulk(HttpServletRequest request, HttpServletResponse response) {
			//TODO nTake in a file and add to map
	    	//return new ArrayList<SMS>(smss.values());
	    	return null;
	    }
		
		@RequestMapping(value="/api/1.0/company/json", method=RequestMethod.GET, produces="application/json") 
		public @ResponseBody List<SMS> dummyList(@RequestParam(value="id", required=false) String id, 
				@RequestParam(value="param1", required=false) String param1, 
				@RequestParam(value="param2", required=false) String param2) {
			
	    	return new ArrayList<SMS>(smss.values());
	    	
	    }	    
		
		@RequestMapping(value="/sms/v2/{name}/{id}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody SMS getSMSForName(@PathVariable("name") String name, @PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
			
			SMS toReturn = null;
	    	if(smss.get(id)!=null){
	    		response.setStatus(200);
	    		toReturn =  smss.get(id);
	    		toReturn.setCharacters("SMS "+ id + " sent by " + name);
	    		toReturn.setTimeStamp(""+ System.currentTimeMillis());
	    		return toReturn;
	    	}
	    	
	    	response.setStatus(404);
	    	return null;
		}	
			
}
