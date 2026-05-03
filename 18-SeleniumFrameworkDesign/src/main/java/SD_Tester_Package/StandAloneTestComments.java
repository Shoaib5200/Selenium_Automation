package SD_Tester_Package;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestComments {

    public static void main(String[] args) {
    	
    	// Product name to be searched and validated (can be externalized in future via config/test data)
    	String productName = "ADIDAS ORIGINAL";

        // ================================
        // Browser Setup
        // ================================
        // WebDriverManager automatically handles driver binaries (no manual setup required)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Implicit wait (applies globally to all findElement calls)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Maximize browser window for consistent UI rendering
        driver.manage().window().maximize();

        // ================================
        // Login Flow
        // ================================
        // Navigate to application URL
        driver.get("https://rahulshettyacademy.com/client/");
        
        // Enter login credentials (should be moved to config file in framework)
        driver.findElement(By.id("userEmail")).sendKeys("shoaibdanish@qa.com");
        driver.findElement(By.id("userPassword")).sendKeys("Hello1@34");
        
        // Click login button
        driver.findElement(By.id("login")).click();
        
        // ================================
        // Wait for Products Page
        // ================================
        // Explicit wait for product cards to be visible (better than Thread.sleep)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb-3")));

        // ================================
        // Product Selection
        // ================================
        // Capture all product cards
        List<WebElement> products = driver.findElements(By.className("mb-3"));
        
        // Use Java Streams to filter and find the desired product by name
        WebElement prod = products.stream()
        		.filter(product ->
        			product.findElement(By.cssSelector("b"))   // Locate product title inside card
        				.getText()
        					.equals(productName))              // Match with required product
        		.findFirst()
        		.orElse(null);                               // Returns null if not found
        
        // Click "Add to Cart" button for selected product
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        
        // ================================
        // Wait for Add-to-Cart Confirmation
        // ================================
        // Wait for toast message (confirmation popup)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        
        // Wait until loading animation disappears (ensures UI stability)
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        
        // Navigate to Cart page
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        
        // ================================
        // Cart Validation
        // ================================
        // Get all product names in cart
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        
        // Verify if selected product exists in cart using stream
        Boolean match = cartProducts.stream()
        		.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        
        // Assertion to validate product is successfully added to cart
        Assert.assertTrue(match);
        
        // ================================
        // Checkout Process
        // ================================
        // Click on checkout button
        driver.findElement(By.cssSelector(".totalRow button")).click();         
        
        // ================================
        // Country Selection using Actions class
        // ================================
        // Actions class used for advanced user interactions (keyboard/mouse)
        Actions a = new Actions(driver);
        
        // Type country name in input field
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Pakistan")
         .build()
         .perform();
        
        // Wait for dropdown suggestions to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        
        // Select country from dropdown
        driver.findElement(By.cssSelector(".ta-results")).click();
        
        // Submit the order
        driver.findElement(By.cssSelector(".action__submit")).click();
        
        // ================================
        // Order Confirmation Validation
        // ================================
        // Capture confirmation message
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        
        // Print message for debugging/logging
        System.out.println(confirmMessage);
        
        // Validate confirmation message
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
        
        // ================================
        // Cleanup
        // ================================
        // Close browser (important to release resources)
        driver.quit();
    }
}