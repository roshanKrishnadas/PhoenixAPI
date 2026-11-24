package com.APITest;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.Details;
import com.api.services.DashBoardService;
import com.api.utils.SpecUtil;

public class DetailsAPITest {
	private DashBoardService dashboardservice;
	private Details detailPayload;
	
	@BeforeMethod(description =" instantiate the dashboard service and Details record")
	public void setUp() {
		dashboardservice=new DashBoardService();
		detailPayload=new Details("created_today");
	}
	
	
	@Test
	public void details() {
		dashboardservice.details(Role.FD, detailPayload)
		.then()
		.spec(SpecUtil.responseSpec_OK())
		.body("message",equalTo("Success"));
	}

}
