package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.api.request.model.CreateJobFD;
import com.api.request.model.FDCustomerAddess;
import com.api.request.model.FDCustomerProduct;
import com.api.request.model.FdCustomerData;
import com.api.request.model.Problems;
import com.dataproviders.api.bean.CreateJobBean;

public class CreateJobMapper {
	
	private CreateJobMapper() {
		
	}
public static CreateJobFD mapper(CreateJobBean bean) {
	//bean--------createJob Payload object
	int mst_service_location_id=Integer.parseInt(bean.getMst_service_location_id());
	int mst_platform_id=Integer.parseInt(bean.getMst_platform_id());
	int mst_warrenty_status_id=Integer.parseInt(bean.getMst_warrenty_status_id());
	int mst_oem_id=Integer.parseInt(bean.getMst_warrenty_status_id());
	
	//CreateJobFD(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id,
		//	FdCustomerData customer, FDCustomerAddess customer_address, FDCustomerProduct customer_product,
		//	List<Problems> problems)
	
	FdCustomerData customerdata=new FdCustomerData(bean.getCustomer__first_name(), bean.getCustomer__last_name(), bean.getCustomer__mobile_number(), bean.getCustomer__mobile_number_alt(), bean.getCustomer__email_id(), bean.getCustomer__email_id_alt());
	//FdCustomerData(String first_name, String last_name, String mobile_number, String mobile_number_alt,
			//String email_id, String email_id_alt)
	
	FDCustomerAddess customerAdd=new FDCustomerAddess(bean.getCustomer_address__flat_number(), bean.getCustomer_address__apartment_name(), bean.getCustomer_address__street_name(), bean.getCustomer_address__landmark(), bean.getCustomer_address__area(), bean.getCustomer_address__pincode(), bean.getCustomer_address__country(), bean.getCustomer_address__state());
	//FDCustomerAddess(String flat_number, String apartment_name, String street_name, String landmark,
			//String area, String pincode, String country, String state) 
	
	int product_id=Integer.parseInt(bean.getCustomer_product__product_id());
	int mst_model_id=Integer.parseInt(bean.getCustomer_product__mst_model_id());
	FDCustomerProduct customerProd=new FDCustomerProduct(bean.getCustomer_product__dop(), bean.getCustomer_product__serial_number(), bean.getCustomer_product__imei1(), bean.getCustomer_product__imei2(), bean.getCustomer_product__popurl(), product_id, mst_model_id);
	//FDCustomerProduct(String dop, String serial_number, String imei1, String imei2, String popurl,
		//	int product_id, int mst_model_id) 
	
	List<Problems> problemList=new ArrayList<Problems>();
    int id=Integer.parseInt(bean.getProblems__id());
    
	Problems problem=new Problems(id, bean.getProblems__remark());
	problemList.add(problem);
	
 CreateJobFD createJobPayload=new CreateJobFD(mst_service_location_id, mst_platform_id, mst_warrenty_status_id, mst_oem_id, customerdata, customerAdd, customerProd, problemList);
return createJobPayload;
}
}
