import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Open the provided URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Question 1
		// Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked.
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		
		// Question 2
		// How to get the Count of number of check boxes present in the page. 
		System.out.println("The checkbox count is :"+ driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}
}
