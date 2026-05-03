package SD_Tester_Package;
import java.io.File;
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

public class StandAloneTest {

    public static void main(String[] args) {
    	
    	String productName = "ADIDAS ORIGINAL";

        // Setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Use data
        driver.get("https://rahulshettyacademy.com/client/");
        driver.findElement(By.id("userEmail")).sendKeys("shoaibdanish@qa.com");
        driver.findElement(By.id("userPassword")).sendKeys("Hello1@34");
        driver.findElement(By.id("login")).click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb-3")));

        
        List<WebElement> products = driver.findElements(By.className("mb-3"));
        
        WebElement prod = products.stream()
        		.filter(product->
        			product.findElement(By.cssSelector("b"))
        				.getText()
        					.equals(productName)).findFirst().orElse(null);
        
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        
        driver.findElement(By.cssSelector(".totalRow button")).click();         
        
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Pakistan").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        
        driver.findElement(By.cssSelector(".ta-results")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        System.out.println(confirmMessage);
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
                
        driver.quit();		// Close browser
    }
}