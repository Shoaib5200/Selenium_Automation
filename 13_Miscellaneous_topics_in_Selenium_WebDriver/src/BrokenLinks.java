import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver",
				"C://ShoaibDanish//Automation_Practice//Selenium//Chrome_Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver(options); // Invoke browser		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// driver.manage().window().maximize(); // Maximize the browser window
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
		
		driver.quit();
		
		
		
		//broken URL
		// Step-1 is to get all URL's and gets you the status code
		// Java methods will call URL's
	}

}
