package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.api.request.model.UserCredentails;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReaderUtil {

	public static <T> Iterator<T> loadJSON(String filename,Class<T[]> classes)  {
		
	InputStream ip = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);

	          
	    ObjectMapper mapper =new ObjectMapper();
	       T[] classArray;
	       List<T> list = null;
		try {
			classArray = mapper.readValue(ip, classes);
			list = Arrays.asList(classArray);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return list.iterator() ;      
	                 
	    
	             
	              
	             
	}         
}
