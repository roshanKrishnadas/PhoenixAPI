package com.APITest;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.CreateJobFD;
import com.api.request.model.FDCustomerAddess;
import com.api.request.model.FDCustomerProduct;
import com.api.request.model.FdCustomerData;
import com.api.request.model.Problems;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITest {
	//probel pojo class
	
	@Test
	public void createJobTest() {
		Problems problem1=new Problems(2, "screen issue");
		//declaration initilaizatio of array type is Problems which we have created the POJO
		List<Problems>problem=new ArrayList<Problems>();
		problem.add(problem1);
		
		FDCustomerProduct customerproduct=new FDCustomerProduct("2026-02-01T18:30:00.000Z", "124467466792792", "124467466792792", "124467466792792", "2026-02-01T18:30:00.000Z", 1, 1);
		FDCustomerAddess customerAdd=new FDCustomerAddess("helloflAT", "namsate aprt", "gajANAN", "wola", "400708", "560023", "mh", "");
		FdCustomerData customer= new FdCustomerData("ros", "hos", "1234967891", "", "hos@gmail.com", "");
		CreateJobFD createjobfd=new CreateJobFD(0, 2, 1, 1, customer, customerAdd, customerproduct, problem);
		given()
		  .spec(SpecUtil.requestWithAuth(Role.FD, createjobfd))
		 .when()
	  .post("/job/create")
	.then()
	 .spec(SpecUtil.responseSpec_OK())
	 .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response_Schema/CreateJOBFD.json"))
	 .body("message", Matchers.equalTo("Job created successfully. "))
	 .body("data.mst_service_location_id", Matchers.equalTo(1))
	 .body("data.job_number", Matchers.startsWith("JOB_"));
		
	}

}
