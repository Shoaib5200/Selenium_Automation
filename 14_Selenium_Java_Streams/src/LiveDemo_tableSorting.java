import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo_tableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// 1. Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// 2. Capture all web elements into List
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		// 3. Capture text of all webelements into new(original) list
		List<String> originalList =  elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		// 4. Sort on the original list of Step 3 -> Sorted list
		List<String> sortedList =  originalList.stream().sorted().collect(Collectors.toList());
		
		// 5. Compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
	}

}
