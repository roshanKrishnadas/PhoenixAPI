package com.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.request.model.CreateJobFD;
import com.api.request.model.FDCustomerAddess;
import com.api.request.model.FDCustomerProduct;
import com.api.request.model.FdCustomerData;
import com.api.request.model.Problems;
import com.dataproviders.DataProvidersUtils;
import com.github.javafaker.Faker;

public class Faker_Demo2 {
	 final static String COUNTRY="India";
	public static void main(String[] args) {
		//i want to create a Fake CreateJobAPI Request
		//i want to create a Fake Customer Object
		
		Locale local=new Locale("en-IND");
		Faker faker=new Faker(local);
		
		String firstName=faker.name().firstName();
		String lastName=faker.name().firstName();
		String mobileNumber=faker.numerify("63########");
		String mobileNumberAlt=faker.numerify("733#######");
		String emailId=faker.internet().emailAddress();
		String emailIdAlt=faker.internet().emailAddress();
		FdCustomerData customerData = new FdCustomerData(firstName, lastName, mobileNumber, mobileNumberAlt, emailId, emailIdAlt);
		System.out.println(customerData);
		
		String flatNumber=faker.numerify("###");
		String apartment_name=faker.address().streetName();
		String streetName=faker.address().streetName();
		String landmark=faker.address().streetName();
		String area=faker.address().streetName();
		String pincode=faker.numerify("#####");
		
		String state=faker.address().state();
		
		
		FDCustomerAddess customerAddress = new FDCustomerAddess(flatNumber, apartment_name, streetName, landmark, area, pincode, COUNTRY, state);
		System.out.println(customerAddress);
		
		String dop=DateTimeUtil.getTimeWithDaysAgo(1);
		String serialNo=faker.numerify("###############");
		String popURL=faker.internet().url();
		FDCustomerProduct customerProd=new FDCustomerProduct(dop, serialNo, serialNo, serialNo, popURL, 1, 1);
		System.out.println(customerProd);
		
		String fakeRemark=faker.lorem().sentence(5);
		Random random=new Random();
		int problemID=random.nextInt(26)+1;
		Problems problem=new Problems(problemID, fakeRemark);
		
		List<Problems> problemList=new ArrayList<Problems>();
		problemList.add(problem);
		
		CreateJobFD CreateJobFDPayLoad =new CreateJobFD(0, 2, 1, 1, customerData, customerAddress, customerProd, problemList);
	}
	
}
