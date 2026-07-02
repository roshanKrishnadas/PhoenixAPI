package com.APITest;

import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserdetailsAPITest {
	
	@Test(description="Verify the user details are shown properly",groups={"regression","smoke"})
	public void userDetailsTest() throws IOException {
		
		
		given()
		 .spec(requestWithAuth(FD))
		.when()
		 .get("userdetails")
	    .then()
	     .spec(responseSpec_OK())
	     .body("message",equalTo("Success"))
	     //.body("data.first_name", equalTo("fd"))
	     //.body("data.id",equalTo(4))
	     .body(matchesJsonSchemaInClasspath("Response_Schema/UserDetails.json"));
		
		
	}

}
