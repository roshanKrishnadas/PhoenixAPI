package com.APITest;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.utils.AuthTokenGenerator;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.http.ContentType.*;

import static  com.api.utils.configManager.*;

import static io.restassured.RestAssured.*;

public class MasterFDAPITest {
	@Test
	public void createJobFd() {
		given()
		.spec(SpecUtil.requestWithAuth(Role.FD))
	   .when()
	    .post("/master")
	   .then()
	    .spec(SpecUtil.responseSpec_OK())
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
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response_Schema/MasterFD.json"));
	   
		
	}
	@Test
	public void createJob_MissingHeaders() {
		given()
		.spec(SpecUtil.requestSpec())
	   .when()
	    .post("/master")
	   .then()
	    .spec(SpecUtil.responseSpec_textHTML(401));
	}

}
