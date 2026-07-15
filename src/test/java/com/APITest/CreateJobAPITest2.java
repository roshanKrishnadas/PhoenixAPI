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
import com.api.utils.FakerDataGenerator;
import com.github.javafaker.Faker;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CreateJobAPITest2 {
	private CreateJobFD createjobfd;
	
	//probel pojo class
	@BeforeTest(description="creates the CreateJobAPI payload ")
	public void setUp() {
		createjobfd=FakerDataGenerator.generateFakerCreateJobData();
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
