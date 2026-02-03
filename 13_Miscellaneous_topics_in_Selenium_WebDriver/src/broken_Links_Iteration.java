import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class broken_Links_Iteration {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C://ShoaibDanish//Automation_Practice//Selenium//Chrome_Driver//chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.manage().window().maximize(); // Maximize the browser window
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link: links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			if(respCode>400) {
				System.out.println("The link with text ***"+link.getText()+"*** is broken with response code "+respCode);
				Assert.assertTrue(false);
			}
		}
	}
}
