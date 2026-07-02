package com.api.utils;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.ANY;
import static io.restassured.http.ContentType.JSON;

import static org.hamcrest.Matchers.*;

import static com.api.constant.Role.*;

import com.api.constant.Role;
import com.api.request.model.UserCredentails;

import static com.api.utils.configManager.*;

public class AuthTokenGenerator {

	private AuthTokenGenerator() {
		
	}
	public static String getToken(Role role) {
		UserCredentails user=null;
		if(role==FD) {
			user=new UserCredentails("iamfd","password");
		}
		else if(role==SUP) {
			user=new UserCredentails("iamsup", "password");
		}
      else if(role==ENG) {
    	  user=new UserCredentails("iameng", "password");
		}
    else if(role==QC) {
    	user=new UserCredentails("iamqc", "password");
     }
		String token=given()
		  .baseUri(getProperty("BASE_URI"))
		  .contentType(JSON)
		  .and()
		  .accept(ANY)
		  .body(user)
		.when()
		 .post("login")
		.then()
		 .log().ifValidationFails()
		 .statusCode(200)
		 .body("message", equalTo("Success"))
		 .extract()
		 .body()
		 .jsonPath()
		 .getString("data.token");
		
		System.out.println("------------------------");
		return token;
	}

}
