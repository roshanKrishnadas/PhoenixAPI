package com.api.utils;

public class Demo {
 int a;
 int b;
 public Demo(int a, int b) {
	 this.a=a;
	 this.b=b;
 }
 public void setA(int a) {
	 a=3;
 }
 public void setB(int b) {
	 b=3;
 }
 public int getIntA() {
	 return a;
 }
 public int getIntB() {
	 return b;
 }
 
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Demo d =new Demo(1, 1);
		System.out.println(d.a +","+d.b);
		
      
	}
	

}
