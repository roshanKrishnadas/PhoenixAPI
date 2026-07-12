package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataproviders.api.bean.UserBEAN;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {
/*
 * constructor is private
 * all the method will be static	


*/
	private CSVReaderUtil() {
		
	}
	
public static <T> Iterator<T> loadCSVFile(String pathOfCSVFile,Class<T> bean) {
		
		InputStream ip = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);
		InputStreamReader ir=new InputStreamReader(ip);
		CSVReader  csvRea=new CSVReader(ir);
		
		//Class<UserBEAN> bean=UserBEAN.class;
      CsvToBean<T> csb =new CsvToBeanBuilder(csvRea)
    		                   .withType(bean)
    		                   .withIgnoreEmptyLine(true)
    		                   .build();
      
       List<T> List = csb.parse(); 
       
               return List.iterator();
      
	}
}
	