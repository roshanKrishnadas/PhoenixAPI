package com.APITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import com.api.constant.Role;
import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CountAPITest {
     @Test(description="verifying the CountAPI is giving correct Response",groups= {"api","regression","smoke"})
	public void verifyCount() {
		given()
		 .spec(requestWithAuth(Role.FD))
	    .when()
	     .get("/dashboard/count")
	    .then()
	     .spec(responseSpec_OK())
	     .body("message",equalTo("Success"))
		 .body("data", notNullValue())
		 .body("data.size()",equalTo(3))
	     .body("data.count",everyItem(greaterThanOrEqualTo(0)))
	     .body("data.label", everyItem(not(blankOrNullString())))
	     .body("data.key", containsInAnyOrder("pending_for_delivery","created_today","pending_fst_assignment"))
	     .body(matchesJsonSchemaInClasspath("Response_Schema/CountFD.json"));
	 
	}
     @Test(description="verifying the MasterAPI  is giving 401 status code for invalid token",groups= {"api","negative","regression","smoke"})
     public void countFd_MissingHeaders() {
    	 given()
		 .spec(requestSpec())
	    .when()
	     .get("/dashboard/count")
	    .then()
	     .spec(responseSpec_textHTML(401));
     }
}
