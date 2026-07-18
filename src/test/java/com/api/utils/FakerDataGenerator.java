package com.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.request.model.CreateJobFD;
import com.api.request.model.FDCustomerAddess;
import com.api.request.model.FDCustomerProduct;
import com.api.request.model.FdCustomerData;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;

public class FakerDataGenerator {
	private final static String COUNTRY="India";
	 private  final static Locale LOCAL=new Locale("en-IND");
	private final static Faker FAKER=new Faker(LOCAL);
	private final static Random RANDOM=new Random();
	private final static  int MST_SERVICE_LOCATION_ID=0; 
	private final static  int MST_Platform_ID=2;
	private final static  int MST_WARRENTY_STATUS_ID=1;
	private final static int MST_OEM_ID=1;
	private final static int PRODUCT_ID= 1;
	private final static int  MST_MODEL_ID=1;
	private final static int VALIDPROBLEMIDs[]={1,2,3,4,5,6,7,8,9,10,11,12,15,16,17,19,20,22,24,26,27,28,29};
	private  FakerDataGenerator() {
	}
		public static CreateJobFD generateFakerCreateJobData() {
			FdCustomerData custData=generateCustData();
			FDCustomerAddess custAdd=generateCustAdd();
			FDCustomerProduct custprod=generateCustProd();
			List<Problems> promblemlist=genearteListOfProblem();
			
			CreateJobFD createJobPayload=new CreateJobFD(MST_SERVICE_LOCATION_ID, MST_Platform_ID,  MST_WARRENTY_STATUS_ID, MST_OEM_ID, custData, custAdd, custprod, promblemlist);
           return createJobPayload;

	}
		public static Iterator<CreateJobFD> generateFakerCreateJobData(int count) {
			List<CreateJobFD> createJobFDPayloadList=new ArrayList<CreateJobFD>();
			for(int i=0;i<=count;i++) {
			FdCustomerData custData=generateCustData();
			FDCustomerAddess custAdd=generateCustAdd();
			FDCustomerProduct custprod=generateCustProd();
			List<Problems> promblemlist=genearteListOfProblem();
			CreateJobFD createJobPayload=new CreateJobFD(MST_SERVICE_LOCATION_ID, MST_Platform_ID,  MST_WARRENTY_STATUS_ID, MST_OEM_ID, custData, custAdd, custprod, promblemlist);
			createJobFDPayloadList.add(createJobPayload);
			}
           return createJobFDPayloadList.iterator();

	}
		private static List<Problems> genearteListOfProblem() {
			int count=RANDOM.nextInt(3)+1;
			String fakeRemark;
			int problemID;
			Problems problem;
			List<Problems> problemList=new ArrayList<Problems>();
			for(int i=1;i<=count;i++) {
			 fakeRemark=FAKER.lorem().sentence(2);
			
			 problemID=RANDOM.nextInt(VALIDPROBLEMIDs.length);
		     problem=new Problems(VALIDPROBLEMIDs[problemID], fakeRemark);
			
			
			problemList.add(problem);
			}
			return problemList;
		}
		private static FDCustomerProduct generateCustProd() {
			String dop=DateTimeUtil.getTimeWithDaysAgo(1);
			String serialNo=FAKER.numerify("###############");
			String popURL=FAKER.internet().url();
			FDCustomerProduct customerProd=new FDCustomerProduct(dop, serialNo, serialNo, serialNo, popURL, PRODUCT_ID, MST_MODEL_ID);
			
			return customerProd;
		}
		private static FDCustomerAddess generateCustAdd() {
			String flatNumber=FAKER.numerify("###");
			String apartment_name=FAKER.address().streetName();
			String streetName=FAKER.address().streetName();
			String landmark=FAKER.address().streetName();
			String area=FAKER.address().streetName();
			String pincode=FAKER.numerify("#####");
			
			String state=FAKER.address().state();
			
			
			FDCustomerAddess customerAddress = new FDCustomerAddess(flatNumber, apartment_name, streetName, landmark, area, pincode, COUNTRY, state);
			return customerAddress;
		}
		private static FdCustomerData generateCustData() {
			String firstName=FAKER.name().firstName();
			String lastName=FAKER.name().firstName();
			String mobileNumber=FAKER.numerify("63########");
			String mobileNumberAlt=FAKER.numerify("733#######");
			String emailId=FAKER.internet().emailAddress();
			String emailIdAlt=FAKER.internet().emailAddress();
			FdCustomerData customerData = new FdCustomerData(firstName, lastName, mobileNumber, mobileNumberAlt, emailId, emailIdAlt);
			return customerData;
		}

}
