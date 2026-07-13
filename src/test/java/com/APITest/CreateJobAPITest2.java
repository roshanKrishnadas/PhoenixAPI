package com.APITest;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.constant.MstModelId;
import com.api.constant.OEM;
import com.api.constant.Platform;
import com.api.constant.Problem;
import com.api.constant.Product;
import com.api.constant.Role;
import com.api.constant.ServiceLocation;
import com.api.constant.Warranty_Status;
import com.api.request.model.CreateJobFD;
import com.api.request.model.FDCustomerAddess;
import com.api.request.model.FDCustomerProduct;
import com.api.request.model.FdCustomerData;
import com.api.request.model.Problems;
import com.api.utils.DateTimeUtil;
import com.github.javafaker.Faker;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CreateJobAPITest2 {
	private CreateJobFD createjobfd;
	final static String COUNTRY="India";
	//probel pojo class
	@BeforeTest(description="creates the CreateJobAPI payload ")
	public void setUp() {
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
		
		 createjobfd =new CreateJobFD(0, 2, 1, 1, customerData, customerAddress, customerProd, problemList);
		//createjobfd=new CreateJobFD(ServiceLocation.SERVICE_LOCATION_A.getCode(), Platform.Front_Desk.getCode(), Warranty_Status.IN_WARRANTY.getCode(), OEM.GOOGLE.getCode(), customer, customerAdd, customerproduct, problem);
	}
	@Test(description="verifying the CreateJobAPITest is able to create the IN-Warranty job",groups= {"api","regression","smoke"})
	public void createJobTest() {
		
		given()
		  .spec(requestWithAuth(Role.FD, createjobfd))
		 .when()
	  .post("/job/create")
	.then()
	 .spec(responseSpec_OK())
	 .body(matchesJsonSchemaInClasspath("Response_Schema/CreateJOBFD.json"))
	 .body("message", Matchers.equalTo("Job created successfully. "))
	 .body("data.mst_service_location_id", Matchers.equalTo(1))
	 .body("data.job_number", Matchers.startsWith("JOB_"));
		
	}

}
