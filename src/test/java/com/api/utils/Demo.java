package com.api.utils;

import java.util.Iterator;

import com.dataproviders.api.bean.CreateJobBean;

public class Demo {
 public static void main(String[] args) {
	Iterator<CreateJobBean> a = CSVReaderUtil.loadCSVFile("testData/CreateJobData.csv", CreateJobBean.class);
	
	while (a.hasNext()) {
		System.out.println(a.next());;
		
	}
}
}