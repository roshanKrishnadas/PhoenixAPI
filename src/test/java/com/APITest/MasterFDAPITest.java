package com.APITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import com.api.constant.Role;
import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class MasterFDAPITest {
	@Test(description="verifying the MAsterAPI is giving correct Response",groups= {"api","regression","smoke"})
	public void createJobFd() {
		given()
		.spec(requestWithAuth(Role.FD))
	   .when()
	    .post("/master")
	   .then()
	    .spec(responseSpec_OK())
	    .body("message", equalTo("Success"))
	    .body("data", notNullValue())
		.body("data",hasKey("mst_oem"))
		.body("data",hasKey("mst_model"))
		.body("$",hasKey("message"))
		.body("$",hasKey("data"))
		.body("data.mst_oem.size()", equalTo(2))
		.body("data.mst_model.size()", greaterThan(0))
		.body("data.mst_oem.id", everyItem(notNullValue()))
		.body("data.mst_model.name", everyItem(notNullValue()))
		.body(matchesJsonSchemaInClasspath("Response_Schema/MasterFD.json"));
	   
		
	}
	@Test(description="verifying the MasterAPI  is giving 401 status code for invalid token",groups= {"api","negative","regression","smoke"})
	public void createJob_MissingHeaders() {
		given()
		.spec(requestSpec())
	   .when()
	    .post("/master")
	   .then()
	    .spec(responseSpec_textHTML(401));
	}

}
