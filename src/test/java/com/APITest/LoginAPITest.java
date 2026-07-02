package com.APITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentails;
import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPITest {
	UserCredentails user;
	@BeforeMethod
	public void setUp() {
  user=new UserCredentails("iamfd", "password");
	}
    @Test(description = "Verifying the loging API for FD user",groups = {"api","regression","smoke"})
	public void loginTest() throws IOException {
    	
		  given()
		     .spec(requestSpec(user))
		    .when()
		     .post("login")
		  .then() 
		  .spec(responseSpec_OK())
		  .body("message",equalTo("Success"))
		  .body(matchesJsonSchemaInClasspath("Response_Schema/LoginResponse.json"));
		  
		   
	}
	
}
