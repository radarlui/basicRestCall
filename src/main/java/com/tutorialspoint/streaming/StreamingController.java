package com.tutorialspoint.streaming;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StreamingController {
		

	
	
	
	
	
	//http://stackoverflow.com/questions/20634603/how-do-i-return-a-video-with-spring-mvc-so-that-it-can-be-navigated-using-the-ht
    @RequestMapping(value = "/loadVideoFile", method = RequestMethod.GET)
    @ResponseBody public void getPreview1(HttpServletResponse response) throws IOException {
        
    	String filePath = "/overview.mp4";        
        File file = new File(filePath);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename="+file.getName().replace(" ", "_"));
        
        InputStream iStream = getClass().getResourceAsStream(filePath);
        IOUtils.copy(iStream, response.getOutputStream());
        response.flushBuffer();
    }	
	
	
	
	
	
	
	
	
	
	
	
	
    //@RequestMapping(value = "/loadVideoFile", method = RequestMethod.GET)
    //@ResponseBody public void loadVideoFile(HttpServletResponse response) {
    @ResponseBody public ResponseEntity loadVideoFile(HttpServletResponse response) {
    	ResponseEntity responseEntity = null;
    	try {           
            String filePath = "/overview.mp4";        
            File f = new File(filePath);
            int fileSize = (int) f.length();
            response.setContentLength(fileSize);
            response.setContentType("video/quicktime");
            
            //FileInputStream inputStream = new FileInputStream(filePath);
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            ServletOutputStream outputStream = response.getOutputStream();
//            int value = IOUtils.copy(inputStream, outputStream);
//            System.out.println("File Size :: "+fileSize);
//            System.out.println("Copied Bytes :: "+value);
//            IOUtils.closeQuietly(inputStream);
//            IOUtils.closeQuietly(outputStream);
            
            
            
            
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            HttpHeaders httpHeaders=new HttpHeaders();
            
            httpHeaders.setContentLength(fileSize);
            responseEntity = new ResponseEntity(inputStreamResource, httpHeaders, HttpStatus.OK);            
            
            
            
            
            //response.setStatus(HttpServletResponse.SC_OK);
        } catch (java.io.FileNotFoundException e) {         
            e.printStackTrace();
        	response.setStatus(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {         
        	e.printStackTrace();
        	response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    	finally{
    		return responseEntity;
    	}
    }
    
	   
    //_tc googled stream spring mvc .... looks like good results including
    // found http://stackoverflow.com/questions/23296786/how-stream-video-in-spring-mvc
    // and http://stackoverflow.com/questions/20333394/return-a-stream-with-spring-mvcs-responseentity
    // clean install tomcat7:run
    
    
//		@RequestMapping(value="/sms/v2/{id}", method=RequestMethod.GET, produces="application/json") 
//	    public @ResponseBody SMS getSMS(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
//			
//	    	if(smss.get(id)!=null){
//	    		return smss.get(id);
//	    	}
//	    	
//	    	response.setStatus(404);
//	    	return null;
//	    	
//	    }
//		
//					
}
