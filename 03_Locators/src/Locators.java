import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Implicit Wait - Wait for some seconds to proceed
				
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Shoaib");
		driver.findElement(By.name("inputPassword")).sendKeys("Test");
		driver.findElement(By.className("signInBtn")).click();
		
		//driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Danish");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("shoaib.danish@test.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("shoaib.danish@tester.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("998876");
		
		// Click the button - RESET LOGIN
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("p[class='infoMsg']")).getText());
		
		// Click the button - GO TO LOGIN
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		
		// Fill the SIGN IN PAHE
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//input[@name='chkboxTwo']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
			
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		//driver.close();

	}

}
