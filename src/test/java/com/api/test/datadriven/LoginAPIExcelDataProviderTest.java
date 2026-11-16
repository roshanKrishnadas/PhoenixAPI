package com.api.test.datadriven;

import static com.api.utils.SpecUtil.responseSpec_OK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.services.AuthServices;
import com.dataproviders.api.bean.UserBEAN;

public class LoginAPIExcelDataProviderTest {
	private AuthServices authservice;
	
	@BeforeMethod(description = "Initializing the authservice")
	public void setUp() {
		authservice=new AuthServices();
	}
	
    @Test(description = "Verifying the loging API for FD user",
    		groups = {"api","regression","datadriven"},
    		dataProviderClass = com.dataproviders.DataProvidersUtils.class,
    		dataProvider = "LoginAPIExcelDataProvider"
    		
    		)
	public void loginTest(UserBEAN user)  {
    	
    	authservice.login(user)
		  .then() 
		  .spec(responseSpec_OK())
		  .body("message",equalTo("Success"))
		  .body(matchesJsonSchemaInClasspath("Response_Schema/LoginResponse.json"));
		  
		   
	}
	
}
