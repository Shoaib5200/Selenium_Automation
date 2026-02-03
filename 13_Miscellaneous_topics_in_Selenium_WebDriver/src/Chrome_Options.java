import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Options {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.setProperty("webdriver.chrome.driver",
				"C://ShoaibDanish//Automation_Practice//Selenium//Chrome_Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Invoke browser		
		
		driver.manage().window().maximize(); // Maximize the browser window
		driver.manage().deleteAllCookies();
		
		// Click on any link
		// Login page - verify the login URL
		// driver.manage().deleteCookieNamed("sessionKey");
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
}





