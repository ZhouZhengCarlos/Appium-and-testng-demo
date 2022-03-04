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

	public void Login() throws InterruptedException {
		driver.get(URL());
		getEmailInput().sendKeys("60712317");
		getPasswordInput().sendKeys("chanchos2012.com");
		getSubmitButton().click();
		getNotNowButton().click();
		Thread.sleep(5000);
		
		String previousContext = driver.getContext();
		driver.context("NATIVE_APP");
		driver.findElementByXPath(".//android.widget.Button[@text='BLOCK']").click();
		driver.context(previousContext);
	}

}
