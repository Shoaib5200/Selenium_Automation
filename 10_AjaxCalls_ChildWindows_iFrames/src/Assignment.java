import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");						//Navigate to the website
		
		driver.findElement(By.linkText("Multiple Windows")).click();			// Click on Multiple Windows
		driver.findElement(By.linkText("Click Here")).click();					// Click the link the parent window
		
		Set<String> windows = driver.getWindowHandles(); 						//[parent_Id, Child_ID, subchildID]
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.tagName("h3")).getText());		// Get the text from Child window
		
		driver.switchTo().window(parentId);										// Switch from Child to Parent window
		System.out.println(driver.findElement(By.tagName("h3")).getText());		//Get the text from Child window
	}
}
