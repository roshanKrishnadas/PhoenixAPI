package com.APITest;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.utils.AuthTokenGenerator;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.http.ContentType.*;

import static  com.api.utils.configManager.*;

import static io.restassured.RestAssured.*;

public class MasterFDAPITest {
	@Test
	public void createJobFd() {
		given()
		.baseUri(getProperty("BASE_URI"))
		.contentType(" ")
		.and()
		//.accept(ANY)
		.and()
		.header("Authorization",AuthTokenGenerator.getToken(Role.FD))
		
		.log().uri()
		.log().headers()
		.log().method()
	   .when()
	    .post("/master")
	   .then()
	    .log().body()
	    .statusCode(200)
	    .time(lessThan(1000L))
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
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response_Schema/MAsterFd.json"));
	   
		
	}
	@Test
	public void createJob_MissingHeaders() {
		given()
		.baseUri(getProperty("BASE_URI"))
		.contentType(" ")
		.and()
		//.accept(ANY)
		.and()
		.header("Authorization"," ")
		
		.log().uri()
		.log().headers()
		.log().method()
	   .when()
	    .post("/master")
	   .then()
	    .log().body()
	    .statusCode(401);
	}

}
