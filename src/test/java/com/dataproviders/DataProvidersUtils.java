package com.dataproviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.request.model.CreateJobFD;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobMapper;
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
}
