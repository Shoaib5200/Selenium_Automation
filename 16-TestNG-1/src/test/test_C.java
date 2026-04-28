package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test_C {

	
	@BeforeClass
	public void Bfclass() {
		System.out.println("Method: Bfclass");
	}
	
	@Parameters({"URL"})
	@Test
	public void CarWebLoginLoan(String urlname) {
		// selenium
		System.out.println("Method: Car-WebLoginLoan");
		System.out.println(urlname);
	}

	@Test(groups= {"Smoke"})
	public void CarMobileLoginLoan() {
		// Appium
		System.out.println("Method: Car-MobileLoginLoan");
	}
	
	@Test(dataProvider="getData")
	public void CarMobileSignInLoan(String username, String password) {
		// Appium
		System.out.println("Method: Car-MobileSignInLoan");
		System.out.println(username);
		System.out.println(password);
	}
	
	@BeforeSuite
	public void Bfsuite() {
		System.out.println("Method: Bfsuite, I am number 1.......");
	}
	
	@Test(enabled=false)
	public void CarMobileSignOutLoan() {
		// Appium
		System.out.println("Method: Car-MobileSignOutLoan");
	}
	
	@BeforeMethod
	public void BfMethod() {
		// Appium
		System.out.println("Method: BfMethod, I will execute before every test method in test C class.");
	}
	
	@AfterMethod
	public void AfMethod() {
		// Appium
		System.out.println("Method: AfMethod, I will execute after every test method in test C class.");
	}

	@Test(dependsOnMethods= {"CarMobileSignOutLoan"})
	public void CarAPILoginLoan() {
		// REST API automation
		System.out.println("Method: Car-APILoginLoan");
	}
	
	@DataProvider
	public Object[][] getData() {
		// Appium
				System.out.println("Method: getData");
				// 1st combination - username password - good credit history = row
				// 2nd - username password - no credit history
				// 3rd fraudulent credit history
				Object[][] data = new Object[3][2]; // 3 means how many combination you've, 2 means you are passing two values username and password everytime
				data[0][0]="firstSetUsername";
				data[0][1]="firstpassword";
				
				//Columns in the row are nothing but the values for that particular combination(row)
				// 2nd row
				data[1][0]="secondSetUsername";
				data[1][1]="secondpassword";
				
				// 3rd row
				data[2][0]="thirdSetUsername";
				data[2][1]="thirdpassword";
				
				return data;
	}
	
}
