package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day3 {

	@Test
	public void webLoginCarLoan() {
		//Selenium
		System.out.println("Class (Day 3) - Car Website Login");
	}
	
	@Test
	public void mobileLoginCarLoan() {
		//Appium
		System.out.println("Class (Day 3) - mobileLoginCarLoan");
	}
	
	@BeforeSuite
	public void BfSuit() {
		System.out.println("Class (Day 3) | BeforeSuit | I am no. 1");
	}
	
	@BeforeMethod
	public void beforeEveryMethod() {
		System.out.println("Class (Day 3) | beforeEveryMethod | I am no. 1");
	}
	
	@Test
	public void mobileSignIn() {
		//Appium
		System.out.println("Class (Day 3) - mobileSignIn");
	}
	
	@AfterMethod
	public void afterEveryMethod() {
		System.out.println("Class (Day 3) | afterEveryMethod | I am no. 1");
	}
	@Test
	public void mobileSignOut() {
		//Appium
		System.out.println("Class (Day 3) - mobileSignOut");
	}
	
	@Test
	public void apiLoginCarLoan() {
		//Rest API automation
		System.out.println("Class (Day 3) - Car API Login");
	}
	
}
