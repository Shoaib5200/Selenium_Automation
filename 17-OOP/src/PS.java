import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// Parent class (PS) demonstrating TestNG annotations and reusable methods
public class PS {

	// ============================
	// Regular Method
	// ============================
	
	// This method can be accessed by child classes (e.g., PS1) via inheritance
	// It represents a common reusable function
	public void doThis() {
		System.out.println("Parent call, I am here");	
	}
	
	
	// ============================
	// TestNG Lifecycle Methods
	// ============================
	
	// This method runs BEFORE every @Test method in the child class
	// Used for setup activities (e.g., initializing data, opening browser)
	@BeforeMethod
	public void beforeRun() {
		System.out.println("Run me 1st...");
	}
	
	
	// This method runs AFTER every @Test method in the child class
	// Used for cleanup activities (e.g., closing browser, clearing data)
	@AfterMethod
	public void afterRun() {
		System.out.println("Run me LAST...");
	}
}