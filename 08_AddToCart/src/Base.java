import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String[] itemNeeded = {"Cumcumber", "Brocolli", "Beetroot"};
		
		//Expected
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
				
		// Using list because we have list of products or items on the webpage
		List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i=0;i<products.size();i++) {
			
			String name = products.get(i).getText();
			//format it to get the actual vegateble name, we have to remove the - 1 kg with the vegetable name
			
			//check whether name you extract is present in the arrayList or not
			// convert array into arrayList for easy search
			List itemsNeededList = Arrays.asList(itemNeeded);
			
			if(itemsNeededList.contains("name")) {
				// click on Add to Cart
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
				// Don't use break when u use ArrayList for multiple item
				// Use break statement for a single item
				
				//break;
			}
		}
		
	
	
	
	}
}
