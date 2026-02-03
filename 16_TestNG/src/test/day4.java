package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day4 {
	
	@BeforeClass
	public void beforeClass() {
		//Selenium
		System.out.println("Class (Day 4) | BeforeClassMethod |  Before executing all tests in a class");
	}

	@Test
	public void webLoginHomeLoan() {
		//Selenium
		System.out.println("Class (Day 4) - Home Website Login");
	}
	
	@AfterClass
	public void afterClass() {
		//Selenium
		System.out.println("Class (Day 4) | AfterClassMethod |  After executing all tests in a class");
	}
	
	@Test
	public void mobileLoginHomeLoan() {
		//Appium
		System.out.println("Class (Day 4) - Home Mobile Login");
	}
	
	@Test
	public void apiLoginHomeLoan() {
		//Rest API automation
		System.out.println("Class (Day 4) - Home API Login");
	}
	
}
