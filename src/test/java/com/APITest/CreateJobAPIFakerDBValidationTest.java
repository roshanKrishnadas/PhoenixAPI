package com.APITest;

import static com.api.utils.SpecUtil.requestWithAuth;
import static com.api.utils.SpecUtil.responseSpec_OK;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.CreateJobFD;
import com.api.request.model.FdCustomerData;
import com.api.utils.FakerDataGenerator;
import com.database.dao.CustomerAddressDao;
import com.database.dao.CustomerDao;
import com.database.dao.CustomerJobHeadDAO;
import com.database.models.CustomerAddressDBModel;
import com.database.models.CustomerDBModel;
import com.database.models.CustomerJobHeadDBModel;

public class CreateJobAPIFakerDBValidationTest {
	private CreateJobFD createjobfd;
	
	//probel pojo class
	@BeforeTest(description="creates the CreateJobAPI payload ")
	public void setUp() {
		createjobfd=FakerDataGenerator.generateFakerCreateJobData();
	}
	@Test(description="verifying the CreateJobAPITest is able to create the IN-Warranty job",groups= {"api","regression","smoke"})
	public void createJobTest() {
		
	int customerId=	given()
		             .spec(requestWithAuth(Role.FD, createjobfd))
		           .when()
	                 .post("/job/create")
	               .then()
	                 .spec(responseSpec_OK())
	                 .body(matchesJsonSchemaInClasspath("Response_Schema/CreateJOBFD.json"))
	                 .body("message", Matchers.equalTo("Job created successfully. "))
	                 .body("data.mst_service_location_id", Matchers.equalTo(1))
	                 .body("data.job_number", Matchers.startsWith("JOB_"))
	                 .extract()
	                 .body()
	                 .jsonPath()
	                 .getInt("data.tr_customer_id");
	
                	 FdCustomerData expectedCustomerInfo = createjobfd.customer();
	                 CustomerDBModel actualCustomerInfo = CustomerDao.getCustomerInfo(customerId);
	                 
	                 Assert.assertEquals(actualCustomerInfo.getFirst_name(),expectedCustomerInfo.first_name() );
	                 Assert.assertEquals(actualCustomerInfo.getLast_name(),expectedCustomerInfo.last_name() );
	                 Assert.assertEquals(actualCustomerInfo.getMobile_number(),expectedCustomerInfo.mobile_number() );
	                 Assert.assertEquals(actualCustomerInfo.getMobile_number_alt(),expectedCustomerInfo.mobile_number_alt() );
	                 Assert.assertEquals(actualCustomerInfo.getEmail_id(),expectedCustomerInfo.email_id() );
	                 Assert.assertEquals(actualCustomerInfo.getEmail_id_alt(),expectedCustomerInfo.email_id_alt() );
	                 
	                 CustomerAddressDBModel customerAddactualInfo = CustomerAddressDao.getCustomerAddressInfo(actualCustomerInfo.getTr_customer_address_id());
	                 Assert.assertEquals(customerAddactualInfo.getApartment_name(), createjobfd.customer_address().apartment_name());
	        		 Assert.assertEquals(customerAddactualInfo.getArea(), createjobfd.customer_address().area());
	        		 Assert.assertEquals(customerAddactualInfo.getCountry(), createjobfd.customer_address().country());
	        		 Assert.assertEquals(customerAddactualInfo.getFlat_number(), createjobfd.customer_address().flat_number());
	        		 Assert.assertEquals(customerAddactualInfo.getLandmark(), createjobfd.customer_address().landmark());
	        		 Assert.assertEquals(customerAddactualInfo.getPincode(), createjobfd.customer_address().pincode());
	        		 Assert.assertEquals(customerAddactualInfo.getState(), createjobfd.customer_address().state());
	        		 Assert.assertEquals(customerAddactualInfo.getStreet_name(), createjobfd.customer_address().street_name());
	        		 

	        		 
	        		 
	        		 CustomerJobHeadDBModel customerJobHeadActualInfo = CustomerJobHeadDAO.getCustomerJobHeadInfo(customerId);
	        		 Assert.assertEquals(customerJobHeadActualInfo.getMst_oem_id(),createjobfd.mst_oem_id());
	        		 Assert.assertEquals(customerJobHeadActualInfo.getMst_platform_id(), createjobfd.mst_platform_id());
	        		 Assert.assertEquals(customerJobHeadActualInfo.getMst_service_location_id(), createjobfd.mst_service_location_id());
	        		 Assert.assertEquals(customerJobHeadActualInfo.getMst_warrenty_status_id(), createjobfd.mst_warrenty_status_id());
	        		
	        		 
	        		 
	        		
	                 
	                 
	                 
	                            
	}

}
