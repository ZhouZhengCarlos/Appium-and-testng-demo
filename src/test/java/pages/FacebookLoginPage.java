package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FacebookLoginPage extends Page{
	
	public FacebookLoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public String URL() {
		return "https://m.facebook.com/";
	}
	
	public WebElement getEmailInput() {
		return getById("m_login_email");
	}
	
	public WebElement getPasswordInput() {
		return getById("m_login_password");
	}
	
	public WebElement getSubmitButton() {
		return getByName("login");
	}
	
	public WebElement getNotNowButton() {
		return getByClassName("_2pii");
	}

	public void Login() {
		driver.get(URL());
		getEmailInput().sendKeys("your email");
		getPasswordInput().sendKeys("your password");
		getSubmitButton().click();
		getNotNowButton().click();
	}

}
