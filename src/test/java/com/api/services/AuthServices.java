package com.api.services;

import static com.api.utils.SpecUtil.requestSpec;
import static io.restassured.RestAssured.given;

import com.api.request.model.UserCredentails;

import io.restassured.response.Response;

public class AuthServices {
	private static final String LOGIN_ENDPOINT="login";
	public  Response login(UserCredentails user) {
		 Response response = given()
		     .spec(requestSpec(user))
		    .when()
		     .post(LOGIN_ENDPOINT);
  return response;
	}

}
