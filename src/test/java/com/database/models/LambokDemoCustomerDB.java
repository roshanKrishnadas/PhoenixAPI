package com.database.models;

public class LambokDemoCustomerDB {

	public static void main(String[] args) {
		CustomerDBModel customer =new CustomerDBModel("roshan", "maskey", "1234567899", "", "abc@gmail.com", "");
		CustomerDBModel customer1=new CustomerDBModel();
       customer1.setFirst_name("acvdg");
       System.out.println(customer1.getFirst_name());

	}

}
