package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCsv {

	public static void main(String[] args) throws IOException, CsvException {
		/*
		 * File file=new File(
		 * "D:\\Pheonix\\com.MyPhoenixTest\\src\\main\\resources\\testData\\LoginCreds.csv"
		 * ); FileReader fr=new FileReader(file);
		 */
		InputStream ip = Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCreds.csv");
		InputStreamReader ir=new InputStreamReader(ip);
		CSVReader  csvRea=new CSVReader(ir);
		List<String[]> datalist = csvRea.readAll();
		
		for(String[] a:datalist) {
			for(String b:a) {
			System.out.print(b+ " ");
			}
			System.out.println("");
		}
		

	}

}
