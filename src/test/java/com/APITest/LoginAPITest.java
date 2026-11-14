package com.APITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentails;
import com.api.services.AuthServices;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPITest {
	 private UserCredentails user;
	 private AuthServices authService;
	
	@BeforeMethod
	public void setUp() {
      user=new UserCredentails("iamfd", "password");
      authService=new AuthServices();
	}
    @Test(description = "Verifying the loging API for FD user",groups = {"api","regression","smoke"})
	public void loginTest() throws IOException {
    	authService.login(user)
		 .then() 
		  .spec(responseSpec_OK())
		  .body("message",equalTo("Success"))
		  .body(matchesJsonSchemaInClasspath("Response_Schema/LoginResponse.json"));
		  
		   
	}
	
}
