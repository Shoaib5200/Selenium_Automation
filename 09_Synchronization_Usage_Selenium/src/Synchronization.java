// The entire lecture is based upon the Implicit Wait Section 9, Lecture: 80


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String[] itemNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemNeeded);

		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		//driver.findElement(By.cssSelector("span[class='promoInfo']")).getText();
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
		
	}

	
	public static void addItems(WebDriver driver, String[] itemNeeded) {
		int j=0;
		// Using list because we have list of products or items on the webpage
				List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
				for (int i=0;i<products.size();i++) {
				
					//Brocolli - 1 Kg
					// split based upon the "-"
					String[] name = products.get(i).getText().split("-");
					
					//name[0] = Borocolli
					String formattedName = name[0].trim();
					
					List itemsNeededList = Arrays.asList(itemNeeded);
					if(itemsNeededList.contains(formattedName)) 
					{
						j++;
						
						// click on Add to Cart
						driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						
						// Don't use break when u use ArrayList for multiple item
						// Use break statement for a single item
						//break;
						// 3 items
						if(j==itemNeeded.length)
							break;
					}
				}
	}
}
