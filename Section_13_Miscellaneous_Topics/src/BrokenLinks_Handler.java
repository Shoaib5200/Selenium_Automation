import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks_Handler {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//broken URL issue
		// How to identify a URL is working or not
		// Steps 1- is to get all urls's tied up to the links using Selenium
		// There exist some JAVA methods that can call the status codes
		//if the status code is > 400
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);
		

	}

}
