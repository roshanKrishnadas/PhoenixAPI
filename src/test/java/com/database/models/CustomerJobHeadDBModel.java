package com.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerJobHeadDBModel {
	private String job_number;
	private int tr_customer_id;
	private int tr_customer_product_id;
	private int mst_service_location_id;
	private int mst_platform_id;
	private int mst_warrenty_status_id;
	private int mst_oem_id;

}
