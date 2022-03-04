package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	private int count = 0;
	private static int maxTry = 3;

	public boolean retry(ITestResult iTestResult) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!iTestResult.isSuccess()) {
			if (count < maxTry) {
				count++;
				iTestResult.setStatus(ITestResult.FAILURE);
				return true;
			} else {
				iTestResult.setStatus(ITestResult.FAILURE);
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS);
			return false;
		}
		return false;
	}
}
