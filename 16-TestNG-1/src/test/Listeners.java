package test;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener: Interface which implements TestNG listeners
public class Listeners implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
	    System.out.println("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// screenshot code
		//response if API failed
	    System.out.println("Test Failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	    System.out.println("Test Skipped: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    System.out.println("Test Failed but within success percentage: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
	    System.out.println("Execution Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
	    System.out.println("Execution Finished: " + context.getName());
	}
}
