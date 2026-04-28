package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class test_A {

	@AfterTest
	public void lastExecution() {
		System.out.println("Method: lastExecution, I will execute last."); // automation
		
	}
	
	@Test
	public void Demo() {
		System.out.println("Method: Demo"); // automation
		Assert.assertTrue(false);
	}

	@Test
	public void Bye() {
		System.out.println("Method: Bye"); // automation
	}
	
	@AfterSuite
	public void Afsuite() {
		System.out.println("Method: Afsuite, I am number 1 from last.......");
	}
	
}
