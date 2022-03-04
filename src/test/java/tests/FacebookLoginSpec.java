package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FacebookHomePage;
import pages.FacebookLoginPage;

public class FacebookLoginSpec extends BaseClass{
	
	private FacebookLoginPage loginPage;
	private FacebookHomePage homePage;
	
	@BeforeClass
	public void init() {
		this.loginPage = new FacebookLoginPage(driver);
		this.homePage = new FacebookHomePage(driver);
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
}