package com.api.services;

import static com.api.utils.SpecUtil.requestWithAuth;
import static io.restassured.RestAssured.given;

import com.api.constant.Role;
import com.api.request.model.CreateJobFD;
import com.api.utils.SpecUtil;

import io.restassured.response.Response;

public class JobService {
	private static final String CREATE_JOB_ENDPOINT="/job/create";
	private static final String SEARCH_ENDPOINT="/job/search";
	
	public Response create(Role role,CreateJobFD createjobfd ) {
	Response response = given()
		  .spec(requestWithAuth(role, createjobfd))
		 .when()
	  .post(CREATE_JOB_ENDPOINT);
	return response;
	}
	
	public Response search(Role role,Object payload ) {
		Response response = given()
			               .spec(SpecUtil.requestWithAuth(role))
			               .body(payload)
			               .post(SEARCH_ENDPOINT);
			               
					  
		return response;
		}

}
