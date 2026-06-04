package com.APITest;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentails;

import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPITest {
UserCredentails user=new UserCredentails("iamfd", "password");
    @Test
	public void loginTest() {
		  given()
		     .baseUri("http://64.227.160.186:9000/v1")
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
