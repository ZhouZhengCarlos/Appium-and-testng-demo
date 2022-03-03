package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FacebookHomePage extends Page{

	public FacebookHomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public WebElement getHamburgerMenuButton() {
		return getBySelector("div:nth-child(2) > div:nth-child(1) > div > div > div:nth-child(4)");
	}
	
	public WebElement getProfileButton() {
		return getBySelector("#screen-root > div > div.m > div:nth-child(3)");
	}
	
	public WebElement getProfilePic() {
		return getBySelector("div:nth-child(3) >div:nth-child(8)");
	}
	
	public WebElement getSeeProfilePicButton() {
		return getBySelector("div.m.fixed-container.bottom > div > div > div > div > div:nth-child(4) > div");
	}
	
	public WebElement getReactionButton() {
		return getBySelector("div.m.fixed-container.bottom > div > div:nth-child(3)");
	}

}
