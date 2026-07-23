package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dataproviders.api.bean.UserBEAN;
import com.poiji.bind.Poiji;

public class ExcelReaderUtils {
private ExcelReaderUtils(){
	
}
	public static <T> Iterator<T> loadExcelFile(String sheetName,Class<T> clazz)  {
		
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("testdata/Pheonixtestdata.xlsx");
		            XSSFWorkbook xssfWB=null;;
		            XSSFSheet mysheet=null;
					try {
						xssfWB = new XSSFWorkbook(is);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
					mysheet = xssfWB.getSheet(sheetName);
					
					List<T> dataList = Poiji.fromExcel(mysheet, clazz);
					return dataList.iterator();
		            
	}

}
