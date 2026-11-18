package com.api.test.datadriven;

import static com.api.utils.SpecUtil.requestWithAuth;
import static com.api.utils.SpecUtil.responseSpec_OK;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.CreateJobFD;
import com.api.services.JobService;

public class CreateJobAPIJSONDataProviderTest {
	
private JobService jobservice;
	
	@BeforeTest(description = "instantiating the job service")
	public void setUp() {
		jobservice=new JobService();
	}
	
	@Test(description =" verify creatJob created 100 new job" ,
			groups = {"api","smoke","datadriven","faker"},
	dataProviderClass = com.dataproviders.DataProvidersUtils.class,
	dataProvider = "CreateJobAPIJSONDataProvider")
	
	public  void createJobFakerDataDriven(CreateJobFD createjobfd) {
      jobservice.create(Role.FD, createjobfd)
		
	.then()
	 .spec(responseSpec_OK())
	 .body(matchesJsonSchemaInClasspath("Response_Schema/CreateJOBFD.json"))
	 .body("message", Matchers.equalTo("Job created successfully. "))
	 .body("data.mst_service_location_id", Matchers.equalTo(1))
	 .body("data.job_number", Matchers.startsWith("JOB_"));
	}
	

}
