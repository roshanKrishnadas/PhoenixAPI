package com.APITest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.ANY;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.utils.SpecUtil;

import static com.api.constant.Role.*;

import static com.api.utils.AuthTokenGenerator.*;

import static com.api.utils.configManager.*;

import  io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserdetailsAPITest {
	
	@Test
	public void userDetailsTest() throws IOException {
		
		
		given()
		 .spec(SpecUtil.requestWithAuth(FD))
		.when()
		 .get("userdetails")
	    .then()
	     .spec(SpecUtil.responseSpec_OK())
	     .body("message",equalTo("Success"))
	     //.body("data.first_name", equalTo("fd"))
	     //.body("data.id",equalTo(4))
	     .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response_Schema/UserDetails.json"));
		
		
	}

}
