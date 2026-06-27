package com.APITest;

import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.utils.AuthTokenGenerator;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

import static  io.restassured.http.ContentType.*;

import static com.api.utils.configManager.*;

import static  io.restassured.RestAssured.*;

public class CountAPITest {
     @Test
	public void verifyCount() {
		given()
		 .spec(SpecUtil.requestWithAuth(Role.FD))
	    .when()
	     .get("/dashboard/count")
	    .then()
	     .spec(SpecUtil.responseSpec_OK())
	     .body("message",equalTo("Success"))
		 .body("data", notNullValue())
		 .body("data.size()",equalTo(3))
	     .body("data.count",everyItem(greaterThanOrEqualTo(0)))
	     .body("data.label", everyItem(not(blankOrNullString())))
	     .body("data.key", containsInAnyOrder("pending_for_delivery","created_today","pending_fst_assignment"))
	     .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response_Schema/CountFD.json"));
	 
	}
     @Test
     public void countFd_MissingHeaders() {
    	 given()
		 .spec(SpecUtil.requestSpec())
	    .when()
	     .get("/dashboard/count")
	    .then()
	     .spec(SpecUtil.responseSpec_textHTML(401));
     }
}
