package com.APITest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.ANY;
import static io.restassured.http.ContentType.JSON;

import  static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import  io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserdetailsAPITest {
	
	@Test
	public void userDetailsTest() {
		Header authheader=new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE3ODAzOTYxNDF9.Qj65shtaGxxClhsBP8Y13w8xceEKH4s9gLPMHLdR6Fo");
		given()
		 .baseUri("http://64.227.160.186:9000/v1")
		 .header(authheader)
		 .contentType(JSON)
		 .accept(ANY)
		 .log().uri()
		 .log().method()
		 .log().headers()
		.when()
		 .get("userdetails")
	    .then()
	     .log().body()
	     .statusCode(200)
	     .time(lessThan(1500L))
	     .body("message",equalTo("Success"))
	     .body("data.first_name", equalTo("fd"))
	     .body("data.id",equalTo(4))
	     .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response_Schema/UserDetails.json"));
		
		
	}

}
