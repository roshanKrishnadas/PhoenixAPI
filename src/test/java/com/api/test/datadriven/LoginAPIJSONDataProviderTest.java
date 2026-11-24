package com.api.test.datadriven;

import static com.api.utils.SpecUtil.responseSpec_OK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentails;
import com.api.services.AuthServices;

public class LoginAPIJSONDataProviderTest {
	private AuthServices authService;
	@BeforeMethod
	public void setUp() {
		authService=new AuthServices();
	}
    @Test(description = "Verifying the loging API for FD user",
    		groups = {"api","regression","datadriven"},
    		dataProviderClass = com.dataproviders.DataProvidersUtils.class,
    		dataProvider = "LoginAPIJSONDataProvider"
    		
    		)
	public void loginTest(UserCredentails userCreds)  {
    	
		 authService.login(userCreds)
		  .then() 
		  .spec(responseSpec_OK())
		  .body("message",equalTo("Success"))
		  .body(matchesJsonSchemaInClasspath("Response_Schema/LoginResponse.json"));
		  
		   
	}
	
}
