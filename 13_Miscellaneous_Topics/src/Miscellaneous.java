import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://SHOAIB DANISH//Study Material//Automation//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	//	driver.manage().deleteCookieNamed("sessionKey");
		
		//Session
		
		driver.get("https://google.com/");
		
		String testName = "Selenium";
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target =  new File("C://Users//Administrator//Downloads//Selenium_ScreenShots//Screenshot_"
				+ testName 
				+"_"
				+ String.valueOf(new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date()))
				+".png");           
	                
		FileUtils.copyFile(source, target);
	}
}
