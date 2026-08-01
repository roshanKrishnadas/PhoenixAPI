package com.database.dao;

import java.util.ArrayList;
import java.util.List;

import com.api.request.model.CreateJobFD;
import com.api.utils.CreateJobMapper;
import com.dataproviders.api.bean.CreateJobBean;

public class DemoDao {

	public static void main(String[] args) {
		List<CreateJobBean> beanList = CreateJobPayloadDataDao.getCreateJobPayloadData();
		List<CreateJobFD> payloadList=new ArrayList<CreateJobFD>();
		
		for (CreateJobBean bean : beanList) {
			CreateJobFD payload = CreateJobMapper.mapper(bean);
			payloadList.add(payload);
			
			
		}
		System.out.println("-------------------------------");
		
		for (CreateJobFD createJobFDpayload : payloadList) {
			System.out.println(createJobFDpayload);
			
		}

	}

	
}
