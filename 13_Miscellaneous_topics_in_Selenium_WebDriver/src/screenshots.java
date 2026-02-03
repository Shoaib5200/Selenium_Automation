import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshots {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C://ShoaibDanish//Automation_Practice//Selenium//Chrome_Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Invoke browser		
		driver.manage().window().maximize(); // Maximize the browser window
		driver.get("https://www.google.com/");
		System.out.println("The title of the webpage is: " + driver.getTitle());
		
		/* ---------- Create Date-Time Stamp ---------- */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String dateTime = LocalDateTime.now().format(formatter);
        
        /* ---------- Create Unique Folder ---------- */
        String folderPath = "C://ShoaibDanish//Automation_Practice//Selenium_Practice_Screenshots//Execution_" + dateTime;
        File folder = new File(folderPath);
        folder.mkdirs();
		
     // Take 5 screenshots
        for (int i = 1; i <= 5; i++) {
        /* ---------- Take Screenshot ---------- */
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		/* ---------- Unique Screenshot Name ---------- */
        File destination = new File(folderPath + "//Screenshot_"+ i + " " +dateTime + ".png");
        
		FileUtils.copyFile(src, destination);
		Thread.sleep(1000); // 1 second gap (optional)
        }
        driver.quit();
	}
}
