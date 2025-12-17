import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BroswerActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.uk/");
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.navigate().back();
		driver.navigate().forward();
	}

}
