package com.APITest;

import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.services.UserServices;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserdetailsAPITest {
	private UserServices userservice;
	
	@BeforeMethod(description="initializing the user service")
	public void setUp() {
		userservice=new UserServices();
	}
	
	@Test(description="Verify the user details are shown properly",groups={"regression","smoke"})
	public void userDetailsTest() throws IOException {
		userservice.user(FD)
		.then()
	     .spec(responseSpec_OK())
	     .body("message",equalTo("Success"))
	     //.body("data.first_name", equalTo("fd"))
	     //.body("data.id",equalTo(4))
	     .body(matchesJsonSchemaInClasspath("Response_Schema/UserDetails.json"));
		
		
	}

}
