import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C://ShoaibDanish//Automation_Practice//Selenium//Chrome_Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Invoke browser
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize(); // Maximize the browser window
		
		// 1. Give the count of all links available on the webpage
		driver.findElements(By.tagName("a")).size();
		System.out.println("The number of links on this webpage: " + driver.findElements(By.tagName("a")).size());

		// 2. Give the count of all links available in the footer of the webpage
		// we can limit the scope of the webdriver, we use footerDriver in our example
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("The number of links on the footer of this webpage: " + footerDriver.findElements(By.tagName("a")).size());
		
		// 3. Give the count of all links available in the 1st column of the footer of webpage
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("The number of links in the 1st column of the footer of the webpage: " + columnDriver.findElements(By.tagName("a")).size());
		
		// 4. Click on each link in the column and check if the pages are opening
		for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnLinksTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinksTab);	
		} // opens all the tabs
		System.out.println("****** All links in the 1st column of the footer of the webpage are CLICKED!!! ******");
		
		
		// Get all window handles
		Set<String> windows = driver.getWindowHandles(); //[parent_Id, Child_ID, subchildID]
		Iterator<String>it = windows.iterator();
		String parentId = driver.getWindowHandle();
		
		
/*
 		String parentId = it.next();
		String childId = it.next();
		// Loop through windows
		for (String childWindow : windows) {
		    if (!childWindow.equals(parentId)) {
		        driver.switchTo().window(childWindow);
		        System.out.println("Page Title: " + driver.getTitle());
		    }
		}
*/

		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("Page Title: " + driver.getTitle());
		}
			
			
			// Switch back to parent window
		driver.switchTo().window(parentId);
		//driver.quit();
	}
}
