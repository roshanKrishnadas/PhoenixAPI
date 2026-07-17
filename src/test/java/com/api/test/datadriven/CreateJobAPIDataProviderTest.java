package com.api.test.datadriven;

import static com.api.utils.SpecUtil.requestWithAuth;
import static com.api.utils.SpecUtil.responseSpec_OK;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.CreateJobFD;

public class CreateJobAPIDataProviderTest {
	
	@Test(description="verifying the CreateJobAPITest is able to create the IN-Warranty job",groups= {"api","regression","smoke","csv"},
			dataProviderClass = com.dataproviders.DataProvidersUtils.class,
			dataProvider = "CreateJobAPIDataProvider"
			)
	public void createJobTest(CreateJobFD createjobfd) {
		
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
