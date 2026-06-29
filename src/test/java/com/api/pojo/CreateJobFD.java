package com.api.pojo;

import java.util.List;

public record CreateJobFD(

		int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id,
		FdCustomerData customer, FDCustomerAddess customer_address, FDCustomerProduct customer_product,
		List<Problems> problems) {

}