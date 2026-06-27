package com.APITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentails;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPITest {
UserCredentails user=new UserCredentails("iamfd", "password");
    @Test
	public void loginTest() throws IOException {
    	
		  given()
		     .spec(SpecUtil.requestSpec(user))
		    .when()
		     .post("login")
		  .then() 
		  .spec(SpecUtil.responseSpec_OK())
		  .body("message",equalTo("Success"))
		  .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response_Schema/LoginResponse.json"));
		  
		   
	}
	
}
