package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import pages.CalculatorApp;
import pages.FacebookHomePage;
import pages.FacebookLoginPage;

public class FacebookLoginSpec extends BaseClass{
	
	private FacebookLoginPage loginPage;
	private FacebookHomePage homePage;
	//private CalculatorApp calcApp;
	
	@BeforeClass
	public void init() {
		this.loginPage = new FacebookLoginPage(driver);
		this.homePage = new FacebookHomePage(driver);
		//this.calcApp = new CalculatorApp();
	}
	
	@BeforeMethod 
	public void reset() {
		driver.resetApp();
	}
	
	@Test(retryAnalyzer = Retry.class)
	public void testOne(){
		Reporter.log("Test One");
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Elden Ring");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	}
	
	//@Test
//	public void testTwo(){
//		
//		calcApp.getButtonOne().click();
//		calcApp.getButtonSum().click();
//		calcApp.getButtonOne().click();
//		calcApp.getButtonOne().click();
//		calcApp.getButtonEqual().click();
//		System.out.println("Completed test three");
//	}
	
	@Test(retryAnalyzer = Retry.class)
	public void VerifyLogin(){
		Reporter.log("Verifying Login");
		driver.get(loginPage.URL());
		loginPage.getEmailInput().sendKeys("60712317");
		loginPage.getPasswordInput().sendKeys("chanchos2012.com");
		loginPage.getSubmitButton().click();
		loginPage.getNotNowButton().click();
		homePage.getHamburgerMenuButton().click();
		Assert.assertTrue((homePage.getProfileButton().getText().contains("Zhou Zheng")));
	}
	@Test(retryAnalyzer = Retry.class)
	public void LikeOwnProfilePic() throws InterruptedException {
		Reporter.log("Liking facebook profile picture");
		loginPage.Login();
		
		homePage.getHamburgerMenuButton().click();
		homePage.getProfileButton().click();
		homePage.getProfilePic().click();
		homePage.getSeeProfilePicButton().click();
		int likesCount = Integer.parseInt(homePage.getLikesCount().getText());
		homePage.getReactionButton().click();
		Thread.sleep(2000);
		Assert.assertEquals(Integer.parseInt(homePage.getLikesCount().getText()), likesCount + 1);
//		TouchAction action = new TouchAction(driver);
//		int i=0;
//		boolean flag = true;
//		Dimension windowSize = driver.manage().window().getSize();
//		int x = windowSize.height/2;
//		int y_start = (int) (windowSize.width*0.8);
//		int y_end = (int) (windowSize.width*0.2);
//		for (i = 0; i < 10; i++) {
//			
//			int likesCount = Integer.parseInt(homePage.getLikesCount().getText());
//			homePage.getReactionButton().click();
//			Thread.sleep(2000);
//			Assert.assertEquals(Integer.parseInt(homePage.getLikesCount().getText()), likesCount + 1);
//			action.press(PointOption.point(y_start,x)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//			.moveTo(PointOption.point(y_end, x)).release().perform();
//
//		}
	}
	
}