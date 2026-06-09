package com.APITest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentails;
import com.api.utils.configManager;

import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPITest {
UserCredentails user=new UserCredentails("iamfd", "password");
    @Test
	public void loginTest() throws IOException {
    	
		  given()
		     .baseUri(configManager.getProperty("BASE_URI"))
		     .headers("Content-Type","application/json")
		     .and()
		     .accept(JSON)
		     .body(user)
		     .log().uri()
		     .log().method()
		     .log().body()
		  .when()
		    .post("login")
		  .then()
		  .log().all()
		  .statusCode(200)
		  .time(lessThan(1500L))
		  .body("message",equalTo("Success"))
		  .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response_Schema/LoginResponse.json"));
		  
		   
	}
	
}
