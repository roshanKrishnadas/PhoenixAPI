package com.api.test.datadriven;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentails;
import com.dataproviders.api.bean.UserBEAN;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPIExcelDataProviderTest {
	
    @Test(description = "Verifying the loging API for FD user",
    		groups = {"api","regression","datadriven"},
    		dataProviderClass = com.dataproviders.DataProvidersUtils.class,
    		dataProvider = "LoginAPIExcelDataProvider"
    		
    		)
	public void loginTest(UserBEAN user)  {
    	
		  given()
		     .spec(requestSpec(user))
		    .when()
		     .post("login")
		  .then() 
		  .spec(responseSpec_OK())
		  .body("message",equalTo("Success"))
		  .body(matchesJsonSchemaInClasspath("Response_Schema/LoginResponse.json"));
		  
		   
	}
	
}
