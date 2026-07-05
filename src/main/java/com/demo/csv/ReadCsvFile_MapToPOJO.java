package com.demo.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class ReadCsvFile_MapToPOJO {

	public static void main(String[] args) throws IOException, CsvException {
		
		InputStream ip = Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCreds.csv");
		InputStreamReader ir=new InputStreamReader(ip);
		CSVReader  csvRea=new CSVReader(ir);
		
		
      CsvToBean<UserPOJO> csb =new CsvToBeanBuilder(csvRea)
    		                   .withType(UserPOJO.class)
    		                   .withIgnoreEmptyLine(true)
    		                   .build();
      
       List<UserPOJO> a = csb.parse();
       System.out.println(a.get(0).getPassword());
      
	}

}
