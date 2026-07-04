package com.api.utils;

public class Demo {
 int a;
 int b;
 int c;
 int d;
 public Demo(int a, int b,int c,int d) {
	 this.a=a;
	 this.b=b;
	 this.c=c;
	 this.d=d;
 }
 public void setA(int a) {
	 a=3;
 }
 public void setB(int b) {
	 b=3;
 }
 public void setC(int c) {
	 c=3;
 }
 public void setD(int d) {
	 d=4;
 }
 public int getIntA() {
	 return a;
 }
 public int getIntB() {
	 return b;
 }
 public int getIntC() {
	 return c;
 }
 public int getIntD() {
	 return d;
 }
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Demo d =new Demo(1, 1,1,1);
		System.out.println(d.a +","+ d.b +"," + d.c +"," +d.d);
		
      
	}
	

}
