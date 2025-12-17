import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckBoxHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Open the provided URl
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		// Count the number of all checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[id*='SeniorCitizenDiscount']")).size());
		
		// Increamental Selectbox code begins
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println("Before executing a loop: " + driver.findElement(By.id("divpaxinfo")).getText()+"s.");
		
		Thread.sleep(1000);
		
		for (int i=1; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("After executing a loop: " + driver.findElement(By.id("divpaxinfo")).getText()+"s.");
	}
}
