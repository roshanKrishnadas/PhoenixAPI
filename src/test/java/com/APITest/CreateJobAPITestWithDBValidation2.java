package com.APITest;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.constant.MstModelId;
import com.api.constant.OEM;
import com.api.constant.Platform;
import com.api.constant.Problem;
import com.api.constant.Product;
import com.api.constant.Role;
import com.api.constant.ServiceLocation;
import com.api.constant.Warranty_Status;
import com.api.request.model.CreateJobFD;
import com.api.request.model.FDCustomerAddess;
import com.api.request.model.FDCustomerProduct;
import com.api.request.model.FdCustomerData;
import com.api.request.model.Problems;
import com.api.response.model.CreateJobResponse;
import com.api.utils.DateTimeUtil;
import com.database.dao.CustomerAddressDao;
import com.database.dao.CustomerDao;
import com.database.dao.CustomerProblemsDao;
import com.database.dao.CustomerProductDao;
import com.database.models.CustomerAddressDBModel;
import com.database.models.CustomerDBModel;
import com.database.models.CustomerProblemsDBModel;
import com.database.models.CustomerProductDBModel;

import io.restassured.response.Response;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CreateJobAPITestWithDBValidation2 {
	private CreateJobFD createjobfd;
	private FdCustomerData customer;
	private FDCustomerAddess customerAdd;
	private FDCustomerProduct customerproduct;
	//probel pojo class
	@BeforeTest(description="creates the CreateJobAPI payload ")
	public void setUp() {
		Problems problem1=new Problems(Problem.Poor_battery_life.getCode(), "screen issue");
		//declaration initilaizatio of array type is Problems which we have created the POJO
		List<Problems>problem=new ArrayList<Problems>();
		problem.add(problem1);
		
		customerproduct=new FDCustomerProduct(DateTimeUtil.getTimeWithDaysAgo(01), "027568497792798", "027568497792798", "027568497792798", DateTimeUtil.getTimeWithDaysAgo(01), Product.NEXUS_2.getCode(), MstModelId.Nexus_2blue.getMstModelId());
		 customerAdd=new FDCustomerAddess("ganeshflat", "namse_aprt", "gajANANJI", "wolahah", "400708", "560024", "mh", "");
		 customer= new FdCustomerData("rojks", "hmos", "1834967893", "", "hosaa@gmail.com", "");
		createjobfd=new CreateJobFD(ServiceLocation.SERVICE_LOCATION_A.getCode(), Platform.Front_Desk.getCode(), Warranty_Status.IN_WARRANTY.getCode(), OEM.GOOGLE.getCode(), customer, customerAdd, customerproduct, problem);
	}
	@Test(description="verifying the CreateJobAPITest is able to create the IN-Warranty job",groups= {"api","regression","smoke"})
	public void createJobTest() {
		
  CreateJobResponse response = given()
		          .spec(requestWithAuth(Role.FD, createjobfd))
		        .when()
	              .post("/job/create")
	            .then()
	              .spec(responseSpec_OK())
	               .body(matchesJsonSchemaInClasspath("Response_Schema/CreateJOBFD.json"))
	               .body("message", Matchers.equalTo("Job created successfully. "))
	               .body("data.mst_service_location_id", Matchers.equalTo(1))
	               .body("data.job_number", Matchers.startsWith("JOB_"))
	               .extract().as(CreateJobResponse.class);
	               
 System.out.println(response);
             
	
	  int customerID = response.getData().getTr_customer_id();
	  
	  CustomerDBModel customerDataFromDb = CustomerDao.getCustomerInfo(customerID);
	  Assert.assertEquals(customer.first_name(),customerDataFromDb.getFirst_name());
	  Assert.assertEquals(customer.last_name(), customerDataFromDb.getLast_name());
	  Assert.assertEquals(customer.mobile_number(), customerDataFromDb.getMobile_number());
	  Assert.assertEquals(customer.mobile_number_alt(), customerDataFromDb.getMobile_number_alt());
	  Assert.assertEquals(customer.email_id(), customerDataFromDb.getEmail_id());
	  Assert.assertEquals(customer.email_id_alt(),customerDataFromDb.getEmail_id_alt());
	  
	  
	  System.out.println("----------------------------------------------------");
	  
	  
	  // System.out.println();
	  
	  CustomerAddressDBModel customerAddactualInfo =CustomerAddressDao.getCustomerAddressInfo(customerDataFromDb. getTr_customer_address_id());
	  Assert.assertEquals(customerAddactualInfo.getApartment_name(),customerAdd.
	  apartment_name()); 
	  Assert.assertEquals(customerAddactualInfo.getArea(), customerAdd.area());
	  Assert.assertEquals(customerAddactualInfo.getCountry(),customerAdd.country());
	  Assert.assertEquals(customerAddactualInfo.getFlat_number(),customerAdd.flat_number());
	  Assert.assertEquals(customerAddactualInfo.getLandmark(),customerAdd.landmark());
	  Assert.assertEquals(customerAddactualInfo.getPincode(), customerAdd.pincode()); 
	  Assert.assertEquals(customerAddactualInfo.getState(), customerAdd.state());
	  Assert.assertEquals(customerAddactualInfo.getStreet_name(),customerAdd.street_name());
	  
	  int productID = response.getData().getTr_customer_id();
	  CustomerProductDBModel customerProductActualInfo =CustomerProductDao.getCustomerProductInfo(productID);
	  Assert.assertEquals(customerProductActualInfo.getImei1(),customerproduct. imei1());
	  Assert.assertEquals(customerProductActualInfo.getImei2(),customerproduct.imei2()); 
	  Assert.assertEquals(customerProductActualInfo.getSerial_number(),customerproduct.serial_number());
	  
	  int tr_job_head_id = response.getData().getId();
		 CustomerProblemsDBModel customerProblemsActualInfo = CustomerProblemsDao.getCustomerProblem(tr_job_head_id);
		 Assert.assertEquals(customerProblemsActualInfo.getMst_problem_id(), createjobfd.problems().get(0).id());
		 Assert.assertEquals(customerProblemsActualInfo.getRemark(), createjobfd.problems().get(0).remark());
		 
		 
	}

}
