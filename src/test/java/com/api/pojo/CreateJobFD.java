package com.api.pojo;

import java.util.Arrays;

public class CreateJobFD {
		
private int mst_service_location_id;
private int mst_platform_id;
private int mst_warrenty_status_id;
private int mst_oem_id;
private FdCustomerData customer;
private FDCustomerAddess customer_address;
private FDCustomerProduct customer_product;
private Problems problems[];
/**
 * @param mst_service_location_id
 * @param mst_platform_id
 * @param mst_warrenty_status_id
 * @param mst_oem_id
 * @param customer
 * @param customer_address
 * @param customer_product
 * @param problems
 */
public CreateJobFD(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id,
		FdCustomerData customer, FDCustomerAddess customer_address, FDCustomerProduct customer_product,
		Problems[] problems) {
	super();
	this.mst_service_location_id = mst_service_location_id;
	this.mst_platform_id = mst_platform_id;
	this.mst_warrenty_status_id = mst_warrenty_status_id;
	this.mst_oem_id = mst_oem_id;
	this.customer = customer;
	this.customer_address = customer_address;
	this.customer_product = customer_product;
	this.problems = problems;
}
public int getMst_service_location_id() {
	return mst_service_location_id;
}
public void setMst_service_location_id(int mst_service_location_id) {
	this.mst_service_location_id = mst_service_location_id;
}
public int getMst_platform_id() {
	return mst_platform_id;
}
public void setMst_platform_id(int mst_platform_id) {
	this.mst_platform_id = mst_platform_id;
}
public int getMst_warrenty_status_id() {
	return mst_warrenty_status_id;
}
public void setMst_warrenty_status_id(int mst_warrenty_status_id) {
	this.mst_warrenty_status_id = mst_warrenty_status_id;
}
public int getMst_oem_id() {
	return mst_oem_id;
}
public void setMst_oem_id(int mst_oem_id) {
	this.mst_oem_id = mst_oem_id;
}
public FdCustomerData getCustomer() {
	return customer;
}
public void setCustomer(FdCustomerData customer) {
	this.customer = customer;
}
public FDCustomerAddess getCustomer_address() {
	return customer_address;
}
public void setCustomer_address(FDCustomerAddess customer_address) {
	this.customer_address = customer_address;
}
public FDCustomerProduct getCustomer_product() {
	return customer_product;
}
public void setCustomer_product(FDCustomerProduct customer_product) {
	this.customer_product = customer_product;
}
public Problems[] getProblems() {
	return problems;
}
public void setProblems(Problems[] problems) {
	this.problems = problems;
}
@Override
public String toString() {
	return "CreateJobFD [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id=" + mst_platform_id
			+ ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id + ", customer="
			+ customer + ", customer_address=" + customer_address + ", customer_product=" + customer_product
			+ ", problems=" + Arrays.toString(problems) + "]";
}

}
