package com.APITest;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

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
import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CreateJobAPITest {
	private CreateJobFD createjobfd;
	//probel pojo class
	@BeforeTest(description="creates the CreateJobAPI payload ")
	public void setUp() {
		Problems problem1=new Problems(Problem.Poor_battery_life.getCode(), "screen issue");
		//declaration initilaizatio of array type is Problems which we have created the POJO
		List<Problems>problem=new ArrayList<Problems>();
		problem.add(problem1);
		
		FDCustomerProduct customerproduct=new FDCustomerProduct(DateTimeUtil.getTimeWithDaysAgo(01), "127467466792792", "127467466792792", "127467466792792", DateTimeUtil.getTimeWithDaysAgo(01), Product.NEXUS_2.getCode(), MstModelId.Nexus_2blue.getMstModelId());
		FDCustomerAddess customerAdd=new FDCustomerAddess("helloflAT", "namsate aprt", "gajANAN", "wola", "400708", "560023", "mh", "");
		FdCustomerData customer= new FdCustomerData("ros", "hos", "1234967891", "", "hos@gmail.com", "");
		createjobfd=new CreateJobFD(ServiceLocation.SERVICE_LOCATION_A.getCode(), Platform.Front_Desk.getCode(), Warranty_Status.IN_WARRANTY.getCode(), OEM.GOOGLE.getCode(), customer, customerAdd, customerproduct, problem);
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
