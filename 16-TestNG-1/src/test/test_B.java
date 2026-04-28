package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_B {

	@Test(groups= {"Smoke"})
	public void firstTest() {
		System.out.println("Method: firstTest"); // automation
	}

	@Test
	public void secondTest() {
		System.out.println("Method: secondTest"); // automation
	}
	
	@BeforeTest
	public void prerequiste() {
		System.out.println("Method: prerequiste, I will execute 1st"); // automation
	}
}
