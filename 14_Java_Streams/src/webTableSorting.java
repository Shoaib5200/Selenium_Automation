// ============================
// Selenium automation script to validate table sorting, handle pagination dynamically, extract specific data using Java Streams, and capture screenshots.
// ============================

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

		// Initialize Chrome browser instance
		WebDriver driver = new ChromeDriver();

		// Optional: maximize browser window
		// driver.manage().window().maximize();

		// Navigate to the web application
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on the first column header (Veg/fruit name) to apply sorting
		driver.findElement(By.xpath("//tr//th[1]")).click();

		// Capture all product names from the first column of the table
		List<WebElement> productsName = driver.findElements(By.xpath("//tr//td[1]"));

		// Extract text from WebElements and store in a list (original UI order)
		List<String> originalList = productsName.stream()
				.map(s -> s.getText())
				.collect(Collectors.toList());

		// Create a sorted version of the same list using Java Streams
		List<String> sortedList = originalList.stream()
				.sorted()
				.collect(Collectors.toList());

		// Print sorted list for debugging/verification
		System.out.println(sortedList);

		// Validate that UI sorting matches programmatic sorting
		Assert.assertTrue(originalList.equals(sortedList));

		// ============================
		// Pagination + Search Logic
		// ============================

		// Goal: Find "Rice" across paginated table and print its price

		List<String> price;

		do {
			// Re-fetch elements on each iteration to avoid stale element issues
			List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));

			// Filter rows to find "Rice" and extract its corresponding price
			price = rows.stream()
					.filter(s -> s.getText().contains("Rice"))
					.map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			// Print the price if found
			price.forEach(a -> System.out.println("The price of the desired vegetable is: " + a));

			// If "Rice" not found on current page, navigate to next page
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}

			// Continue looping until the item is found
		} while (price.size() < 1);

		// ============================
		// Screenshot Capture
		// ============================

		// Define test name for screenshot naming
		String testName = "Selenium";

		// Capture screenshot of current browser state
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Create target file path with timestamp to avoid overwriting
		File target = new File("C://Users//Administrator//Downloads//Selenium_ScreenShots//Screenshot_"
				+ testName + "_"
				+ new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date())
				+ ".png");

		// Save screenshot to the specified location
		FileUtils.copyFile(source, target);

		// Close the browser
		driver.quit();
	}

	// Helper method to fetch price of a vegetable from the same row
	// Uses relative XPath to locate the next column (price)
	private static String getPriceVeggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
}