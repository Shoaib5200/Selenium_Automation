import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Scroll down on the  table visible on the  browser window level
		js.executeScript("window.scrollBy(0,500)");

		//		Xpath for the table //table[@name='courses']
//		columns = driver.findElement(By.xpath("//table[@name='courses']//tr"));
//		System.out.println(driver.findElement(By.xpath("//table[@name='courses']//tr")));

		WebElement table = driver.findElement(By.id("product"));
		System.out.println(driver.findElements(By.tagName("tr")).size()+ " is the total count of row(s)");
		System.out.println(driver.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size()+ " is the total count of column(s)");
		
		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"));
		for (int i=0; i<secondRow.size(); i++) {
			System.out.print(secondRow.get(i).getText());
		}
		
//		System.out.println(secondRow.get(0).getText());
//		System.out.println(secondRow.get(1).getText());
//		System.out.println(secondRow.get(2).getText());
	}

}
