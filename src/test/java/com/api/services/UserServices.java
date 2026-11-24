package com.api.services;

import static com.api.constant.Role.FD;
import static com.api.utils.SpecUtil.requestWithAuth;
import static io.restassured.RestAssured.given;

import com.api.constant.Role;

import io.restassured.response.Response;

public class UserServices {
	
	private static final String USER_ENDPOINT="/userdetails";
	
	public Response user(Role role) {
		Response response = given()
		 .spec(requestWithAuth(role))
		.when()
		 .get(USER_ENDPOINT);
		return response;
	}

}
