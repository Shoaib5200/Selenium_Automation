import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableSorting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
 		driver.manage().window().maximize();

		// Open the website
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click the table column
		driver.findElement(By.xpath("//tr//th[1]")).click();

		// Capture all webElements
		List<WebElement> productsName = driver.findElements(By.xpath("//tr//td[1]"));

		// capture text of all webElements into new list
		List<String> originalList = productsName.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort in the list of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		// compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));

		// scan the name column with getText -> Rice -> print the price of the price
		List<String> price = productsName.stream().filter(s -> s.getText().contains("Beans"))
				.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));
		
		// Take screenshots
		String testName = "Selenium";
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target =  new File("C://Users//Administrator//Downloads//Selenium_ScreenShots//Screenshot_"
				+ testName 
				+"_"
				+ String.valueOf(new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date()))
				+".png");           
	                
		FileUtils.copyFile(source, target);
		
		driver.quit();
	}

	private static String getPriceVeggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
}