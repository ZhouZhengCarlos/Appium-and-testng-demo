package pages;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		Reporter.log("Test starting: " + result.getName());
	}
	
	public void onTestSuccessI(ITestResult result) {
		Reporter.log("Test success: " + result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test failed: " + result.getName());
	}
}
