import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SumOfTableValues {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Scroll down on the  table visible on the  browser window level
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(3000);
		// Scroll down the particular table
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i=0; i<values.size(); i++) {
			System.out.println(Integer.parseInt(values.get(i).getText()));
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		
		//sum = sum + Integer.parseInt(values.get(i).getText());
		System.out.println("The sum of the numbers: "+ sum);
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
	}
}
