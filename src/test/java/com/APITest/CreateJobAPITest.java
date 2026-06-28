package com.APITest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.pojo.CreateJobFD;
import com.api.pojo.FDCustomerAddess;
import com.api.pojo.FDCustomerProduct;
import com.api.pojo.FdCustomerData;
import com.api.pojo.Problems;
import com.api.utils.SpecUtil;

public class CreateJobAPITest {
	//probel pojo class
	
	@Test
	public void createJobTest() {
		Problems problem1=new Problems(2, "screen issue");
		//declaration initilaizatio of array type is Problems which we have created the POJO
		Problems[] problem=new Problems[1];
		problem[0]=problem1;
		
		FDCustomerProduct customerproduct=new FDCustomerProduct("2026-02-01T18:30:00.000Z", "820467366797292", "820467366797292", "820467366797292", "2026-02-01T18:30:00.000Z", 1, 1);
		FDCustomerAddess customerAdd=new FDCustomerAddess("helloflAT", "namsate aprt", "gajANAN", "wola", "400708", "560023", "mh", "");
		FdCustomerData customer= new FdCustomerData("ros", "hos", "1234567891", "", "hos@gmail.com", "");
		CreateJobFD createjobfd=new CreateJobFD(0, 2, 1, 1, customer, customerAdd, customerproduct, problem);
		given()
		  .spec(SpecUtil.requestWithAuth(Role.FD, createjobfd))
		  
  .log().uri()
  .log().method()
  .log().headers()
	.when()
	  .post("/job/create")
	.then()
	 .log().all()
	 .statusCode(200);
		
	}

}
