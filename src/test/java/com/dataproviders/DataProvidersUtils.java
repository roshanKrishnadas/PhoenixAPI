package com.dataproviders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.request.model.CreateJobFD;
import com.api.request.model.UserCredentails;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobMapper;
import com.api.utils.ExcelReaderUtils;
import com.api.utils.FakerDataGenerator;
import com.api.utils.JSONReaderUtil;
import com.database.dao.CreateJobPayloadDataDao;
import com.dataproviders.api.bean.CreateJobBean;
import com.dataproviders.api.bean.UserBEAN;

public class DataProvidersUtils {
	
	@DataProvider(name = "LoginAPIDataProvider",parallel = true)
public static Iterator<UserBEAN> loginAPIDataProvider() {
		return CSVReaderUtil.loadCSVFile("testData/LoginCreds.csv",UserBEAN.class);
		
	
}
	@DataProvider(name="CreateJobAPIDataProvider",parallel=true)
	public static Iterator<CreateJobFD> createJobAPIDataProvider() {
		Iterator<CreateJobBean> create = CSVReaderUtil.loadCSVFile("testData/CreateJobData.csv",CreateJobBean.class );
		List<CreateJobFD> createFDPayloadList=new ArrayList<CreateJobFD>();
		while(create.hasNext()) {
			CreateJobBean temBean = create.next();
			CreateJobFD tempPayload = CreateJobMapper.mapper(temBean);
			createFDPayloadList.add(tempPayload);
			
		}
		return createFDPayloadList.iterator();
	}
	
	@DataProvider(name="CreateJobAPIFakeDataProvider",parallel=true)
	public static Iterator<CreateJobFD> createJobAPIFakeDataProvider() {
		String fakercount=System.getProperty("fakercount", "5");
		int fakercountInt = Integer.parseInt(fakercount);
		
		
		Iterator<CreateJobFD> createJobPayload = FakerDataGenerator.generateFakerCreateJobData(fakercountInt);
		return createJobPayload;
		}
	@DataProvider(name = "LoginAPIJSONDataProvider",parallel = true)
	public static Iterator<UserCredentails> loginAPIJSONDataProvider() {
			return JSONReaderUtil.loadJSON("testData/LoginAPI.json",UserCredentails[].class);
			
	}
	
	@DataProvider(name = "CreateJobAPIJSONDataProvider",parallel = true)
	public static Iterator<CreateJobFD> CreateJobAPIJSONDataProvider() {
			return JSONReaderUtil.loadJSON("testData/CreateJob.json",CreateJobFD[].class);
			
	}
	@DataProvider(name = "LoginAPIExcelDataProvider",parallel = true)
	public static Iterator<UserBEAN> LoginAPIExcelDataProvider() {
			return ExcelReaderUtils.loadExcelFile("testData/Pheonixtestdata.xlsx","LoginTestData", UserBEAN.class);
			
	}
	@DataProvider(name="CreateJobAPIExcelDataProvider",parallel=true)
	public static Iterator<CreateJobFD> createJobAPIExcelDataProvider() {
		Iterator<CreateJobBean> create = ExcelReaderUtils.loadExcelFile("testData/Pheonixtestdata.xlsx", "CreateJobTestData", CreateJobBean.class);
		List<CreateJobFD> createFDPayloadList=new ArrayList<CreateJobFD>();
		while(create.hasNext()) {
			CreateJobBean temBean = create.next();
			CreateJobFD tempPayload = CreateJobMapper.mapper(temBean);
			createFDPayloadList.add(tempPayload);
			
		}
		return createFDPayloadList.iterator();
	}
	
	
	@DataProvider(name="CreateJobAPIDBDataProvider",parallel=true)
	public static Iterator<CreateJobFD> CreateJobAPIDBDataProvider() {
		List<CreateJobBean> beanList = CreateJobPayloadDataDao.getCreateJobPayloadData();
		List<CreateJobFD> payloadList=new ArrayList<CreateJobFD>();
		
		for (CreateJobBean bean : beanList) {
			CreateJobFD payload = CreateJobMapper.mapper(bean);
			payloadList.add(payload);
			
			
		}
		return payloadList.iterator();
	}
}
