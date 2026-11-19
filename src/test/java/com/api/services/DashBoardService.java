package com.api.services;

import static com.api.utils.SpecUtil.*;
import static io.restassured.RestAssured.given;

import com.api.constant.Role;

import io.restassured.response.Response;

public class DashBoardService {
	private static final String DASH_ENDPOINT="/dashboard/count";
	private static final String DETAILS_ENDPOINT="/dashboard/details";
	
	public Response count(Role role) {
	Response response = given()
		 .spec(requestWithAuth(role))
	    .when()
	     .get(DASH_ENDPOINT);
		return  response;
	}
	public Response countWithNoAuth() {
		Response response = given()
			 .spec(requestSpec())
		    .when()
		     .get(DASH_ENDPOINT);
			return  response;
		}
	public Response details(Role role,Object payload) {
		Response response = given()
			 .spec(requestWithAuth(role))
			 .body(payload)
		    .when()
		     .get(DASH_ENDPOINT);
			return  response;
		}
	
}
