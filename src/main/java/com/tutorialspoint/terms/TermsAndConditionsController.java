package com.tutorialspoint.terms;


import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tutorialspoint.model.AuthorisedContent;
import com.tutorialspoint.model.TermsAndConditions;

@Controller
public class TermsAndConditionsController {
	private Set<String> registeredEmails = new HashSet<String>();
		
//	    @RequestMapping(value="/gsma/terms-conditions", method=RequestMethod.GET) 
//	    public ModelAndView hobbyFormPage() {  
//	        return new ModelAndView("termsAndConditions-form", "termsAndConditions", new TermsAndConditions());  
//	    }

			
    @RequestMapping(value="/gsma/terms-conditions", method=RequestMethod.GET, produces="application/json") 
    public @ResponseBody TermsAndConditions getTermsAndConditions() {
        
    	return new TermsAndConditions();
    }

	
    @RequestMapping(value="/gsma/authorised-content", method=RequestMethod.GET, produces="application/json") 
    public @ResponseBody AuthorisedContent getAuthorisedContent() {
        
    	return new AuthorisedContent();
    }

	
	    @RequestMapping(value="/accept/gsma/terms-conditions", method=RequestMethod.POST, consumes="application/json", produces="application/json") 
	    public @ResponseBody TermsAndConditions postTermsAndConditionsAcceptance(@RequestBody TermsAndConditions termsAndConditionsIncoming,
	            HttpServletResponse response) {
	        
	    	

	    	TermsAndConditions returned = new TermsAndConditions();
	    	String incomingEmail = termsAndConditionsIncoming.getAcceptedUserEmail();
	    	System.out.println("Incoming email: "+incomingEmail);
	    	if(incomingEmail==null || incomingEmail.length()==0 || !registeredEmails.add(incomingEmail)){
	    		returned.setStatusMessage(TermsAndConditions.TERMS_AND_CONDITIONS_STATUS.DUPLICATE_OR_INVALID_EMAIL);
	    		response.setStatus(HttpStatus.BAD_REQUEST.value());
	    		
	    		System.out.println("FAILING incoming email ");
	    	}
	    	else{
	    		returned.setStatusMessage(TermsAndConditions.TERMS_AND_CONDITIONS_STATUS.ACCEPTED);
	    		
	    		System.out.println("OK incoming email ");
	    	}
	    	return returned;
	    }

	    
}
