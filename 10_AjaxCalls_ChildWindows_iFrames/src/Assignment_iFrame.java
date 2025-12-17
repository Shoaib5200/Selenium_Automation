import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_iFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");						//Navigate to the website
		driver.findElement(By.linkText("Nested Frames")).click();

		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
	
		System.out.println(driver.findElement(By.id("content")).getText());
	}
}
