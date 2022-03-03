package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CalculatorApp;
import pages.FacebookHomePage;
import pages.FacebookLoginPage;

public class FacebookLoginSpec extends BaseClass{
	
	private FacebookLoginPage loginPage;
	private FacebookHomePage homePage;
	private CalculatorApp calcApp;
	
	@BeforeClass
	public void init() {
		this.loginPage = new FacebookLoginPage(driver);
		this.homePage = new FacebookHomePage(driver);
		//this.calcApp = new CalculatorApp();
	}
	
	@Test
	public void testOne(){
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Elden Ring");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		System.out.println("Completed test one");
	}
	
	@Test
	public void testTwo(){
		
		calcApp.getButtonOne().click();
		calcApp.getButtonSum().click();
		calcApp.getButtonOne().click();
		calcApp.getButtonOne().click();
		calcApp.getButtonEqual().click();
		System.out.println("Completed test three");
	}
	
	@Test
	public void VerifyLogin(){
		driver.get(loginPage.URL());
		loginPage.getEmailInput().sendKeys("your number");
		loginPage.getPasswordInput().sendKeys("your password");
		loginPage.getSubmitButton().click();
		loginPage.getNotNowButton().click();
		homePage.getHamburgerMenuButton().click();
		Assert.assertTrue((homePage.getProfileButton().getText().contains("your name")));
	}
	@Test
	public void LikeOwnProfilePic() throws InterruptedException {
		loginPage.Login();

		Thread.sleep(5000);
	
		String previousContext = driver.getContext();
		driver.context("NATIVE_APP");
		driver.findElementByXPath(".//android.widget.Button[@text='BLOCK']").click();
		driver.context(previousContext);
		homePage.getHamburgerMenuButton().click();
		homePage.getProfileButton().click();
		homePage.getProfilePic().click();
		homePage.getSeeProfilePicButton().click();
		
	}
	
}