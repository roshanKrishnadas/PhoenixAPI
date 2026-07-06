package com.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReaderUtil;
import com.dataproviders.api.bean.UserBEAN;

public class DataProvidersUtils {
	
	@DataProvider(name = "LoginAPIDataProvider",parallel = true)
public static Iterator<UserBEAN> loginAPIDataProvider() {
		return CSVReaderUtil.loadCSVFile("testData/LoginCreds.csv");
		
	
}
}
