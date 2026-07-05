package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
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
	
public static void loadCSVFile(String pathOfCSVFile) {
		
		InputStream ip = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);
		InputStreamReader ir=new InputStreamReader(ip);
		CSVReader  csvRea=new CSVReader(ir);
		
		
      CsvToBean<UserBEAN> csb =new CsvToBeanBuilder(csvRea)
    		                   .withType(UserBEAN.class)
    		                   .withIgnoreEmptyLine(true)
    		                   .build();
      
       List<UserBEAN> a = csb.parse();
       System.out.println(a);
      
	}
}
	