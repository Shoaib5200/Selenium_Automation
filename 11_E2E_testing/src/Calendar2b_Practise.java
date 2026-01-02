import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar2b_Practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String monthNumber = "6";
		String day = "7";
		String year = "2027";
		String[] expectedList = {monthNumber, day, year};
		
		System.setProperty("webdriver.chrome.driver",
				"C://ShoaibDanish//Automation_Practice//Selenium//Chrome_Driver//chromedriver.exe");
		
		

		WebDriver driver = new ChromeDriver(); // Invoke browser
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize(); // Maximize the browser window
		
		for (int run = 1; run <= 10; run++) {
		    System.out.println("\nIteration:" + run);
		
	    driver.findElement(By.cssSelector(".react-date-picker__button")).click();
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		
		// System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
		
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));		
		for(int i=0; i<actualList.size(); i++) {
		    String value = actualList.get(i).getAttribute("value");
			if (value.length() == 1) {
		        value = "0" + value;
		    }
			System.out.print(value + " ");
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
		System.out.println("");
		}
	}
}
