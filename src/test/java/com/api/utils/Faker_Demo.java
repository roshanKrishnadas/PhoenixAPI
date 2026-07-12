package com.api.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Faker_Demo {

	public static void main(String[] args) {
		Locale local=new Locale("en-NEP");
		Faker faker=new Faker(local);
		          String firstName = faker.name().firstName();
		          String lastName = faker. name().lastName() ;  
		           String buildingNo = faker.address().buildingNumber();
		          System.out.println(firstName +" " + lastName  + " " + buildingNo);
		           System.out.println(faker.address().streetAddress());
		           System.out.println(faker.address().streetName());
		           System.out.println(faker.address().city());
		           System.out.println(faker.phoneNumber().phoneNumber());
		           System.out.println(faker.number().digits(10));
		           System.out.println(faker.numerify("74##########"));
		           System.out.println(faker.internet().emailAddress());
		

	}

}
