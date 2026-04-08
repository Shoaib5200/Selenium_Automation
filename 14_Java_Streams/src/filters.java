import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filters {

    public static void main(String[] args) throws IOException {
        
    	// ============================
    	// Selenium automation to validate table filtering using Java Streams and TestNG assertions
    	// ============================
        // Initialize Chrome browser instance
        WebDriver driver = new ChromeDriver();
        
        // Maximize browser window
        // driver.manage().window().maximize();

        // Navigate to the web application
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
        // Enter "Tomato" in the search field to filter table results
        driver.findElement(By.id("search-field")).sendKeys("Tomato");
        
        // Capture all vegetable name elements from the first column of the table
        List<WebElement> vegtables;
        vegtables = driver.findElements(By.xpath("//tr/td[1]"));
        
        // Apply Java Stream filter to get only elements containing "Tomato"
        // This creates a filtered list based on the search criteria
        List<WebElement> filteredList;
        filteredList = vegtables.stream()
                .filter(veggie -> veggie.getText().contains("Tomato"))
                .collect(Collectors.toList());
        
        // Validate that all displayed results match the filter condition
        // i.e., UI results count should match filtered results count
        Assert.assertEquals(vegtables.size(), filteredList.size());
    }
}