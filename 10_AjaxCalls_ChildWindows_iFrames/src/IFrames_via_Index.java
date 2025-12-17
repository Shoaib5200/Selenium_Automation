import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFrames_via_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://jqueryui.com/droppable/");
		
		// Frames via indexing is not recommended
		

		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		driver.findElement(By.id("draggable")).click();
		
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Accept")).click();
	}

}
