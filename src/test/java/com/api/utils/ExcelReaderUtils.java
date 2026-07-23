package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.request.model.UserCredentails;

public class ExcelReaderUtils {
private ExcelReaderUtils(){
	
}
	public static Iterator<UserCredentails> loadExcelFile() {
		
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("testdata/Pheonixtestdata.xlsx");
		            XSSFWorkbook xssfWB=null;;
		            XSSFSheet sheet=null;
					try {
						xssfWB = new XSSFWorkbook(is);
						sheet = xssfWB.getSheet("LoginTestData");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		           
		             XSSFRow myRow;
		              XSSFCell MyCell;
		             
                       
		          XSSFRow rowHeader = sheet.getRow(0) ;
		          
		          int userNameIndex=-1;
		          int passwordIndex=-1;
		          
		          for (Cell cell:rowHeader) {
		        	 if(cell.getStringCellValue().trim().equalsIgnoreCase("username")) {
		        		 userNameIndex=cell.getColumnIndex();
		        	 }
		        	 if(cell.getStringCellValue().trim().equalsIgnoreCase("password")) {
		        		 passwordIndex=cell.getColumnIndex();
		        	 }
		        	  
		          }
		          System.out.println(userNameIndex + " " + passwordIndex );
		          int lastRowIndex = sheet.getLastRowNum();
		          XSSFRow rowdata;
		          UserCredentails userCredentails;
		          ArrayList<UserCredentails> userList=new ArrayList<UserCredentails>();
		          for(int rowIndex=1;rowIndex<=lastRowIndex;rowIndex++) {
		        	   rowdata = sheet.getRow(rowIndex);
		        	   userCredentails=new UserCredentails(rowdata.getCell(userNameIndex).toString(), rowdata.getCell(passwordIndex).toString());
		        	   userList.add(userCredentails);
		        	   
		          }
		         return  userList.iterator();
	}

}
