package com.api.utils;

import java.util.Iterator;

import com.dataproviders.api.bean.CreateJobBean;

public class ExcelReaderUtils2 {

	public static void main(String[] args) {
		Iterator<CreateJobBean> itet = ExcelReaderUtils.loadExcelFile("testData/Pheonixtestdata.xlsx", "CreateJobTestData", CreateJobBean.class);
		
			while(itet.hasNext()) {
				System.out.println(itet.next());
			}
			
		

	}

	
}
