package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test_D {

	@Parameters({"URL", "APIKey/usrname"})
	@Test
	public void HomeWebLoginLoan(String urlname, String key) {
		// selenium
		System.out.println("Method: Home-WebLoginLoan");
		System.out.println(urlname);
		System.out.println(key);
	}

	@Test
	public void HomeMobileLoginLoan() {
		// Appium
		System.out.println("Method: Home-MobileLoginLoan");
	}

	@Test(groups= {"Smoke"})
	public void HomeAPILoginLoan() {
		// REST API automation
		System.out.println("Method: Home-APILoginLoan");
	}
}
