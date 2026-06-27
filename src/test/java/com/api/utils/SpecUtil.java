package com.api.utils;

import org.hamcrest.Matchers;

import com.api.constant.Role;
import com.api.pojo.UserCredentails;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtil {
	
	//for GET and DELETE
	public static RequestSpecification requestSpec() {
		RequestSpecification requestSpec = new RequestSpecBuilder().
				setBaseUri(configManager.getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.ANY)
				.log(LogDetail.URI)
				.log(LogDetail.METHOD)
				.log(LogDetail.BODY)
				.log(LogDetail.HEADERS)
				.build();
		return requestSpec;
		 

}           //for POST and PUT ,PATCH
	public static RequestSpecification requestSpec(Object Payload) {
		RequestSpecification requestSpec = new RequestSpecBuilder().
				setBaseUri(configManager.getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.ANY).log(LogDetail.URI)
				.setBody(Payload)
				.log(LogDetail.METHOD)
				.log(LogDetail.BODY)
				.log(LogDetail.HEADERS)
				.build();
		return requestSpec;
		 

}
	public static RequestSpecification requestWithAuth(Role role) {
		RequestSpecification requestSpec = new RequestSpecBuilder().
				setBaseUri(configManager.getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.ANY).log(LogDetail.URI)
				.addHeader("Authorization",AuthTokenGenerator.getToken(role))
				.log(LogDetail.METHOD)
				.log(LogDetail.BODY)
				.log(LogDetail.HEADERS)
				.build();
		return requestSpec;
		 
		
	}
	public static ResponseSpecification responseSpec_OK() {
		ResponseSpecification responseSpec = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
	return responseSpec;
	}
	public static ResponseSpecification responseSpec_JSON(int statusCode) {
		ResponseSpecification responseSpec = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(statusCode)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
	return responseSpec;
	}
	public static ResponseSpecification responseSpec_textHTML(int statusCode) {
		ResponseSpecification responseSpec = new ResponseSpecBuilder()
		
		.expectStatusCode(statusCode)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
	return responseSpec;
	}
}