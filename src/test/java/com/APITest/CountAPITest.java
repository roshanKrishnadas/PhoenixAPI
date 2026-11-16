package com.APITest;

import static com.api.constant.Role.FD;
import static com.api.utils.SpecUtil.requestSpec;
import static com.api.utils.SpecUtil.responseSpec_OK;
import static com.api.utils.SpecUtil.responseSpec_textHTML;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.services.DashBoardService;

public class CountAPITest {
	
	private DashBoardService dashboardService;
	
	@BeforeMethod(description = "initializing the dashboardService ")
	public void setUp() {
		dashboardService=new DashBoardService();	
	}
	
     @Test(description="verifying the CountAPI is giving correct Response",groups= {"api","regression","smoke"})
	public void verifyCount() {
    	 dashboardService.count(FD)
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
    	 dashboardService.countWithNoAuth()
	    .then()
	     .spec(responseSpec_textHTML(401));
     }
}
