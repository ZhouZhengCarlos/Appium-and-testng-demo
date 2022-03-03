package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Page {
	protected WebDriverWait wait;
	protected AppiumDriver<MobileElement> driver;
	public Page(AppiumDriver<MobileElement> driver) {
		this.wait = new WebDriverWait(driver, 10);
		this.driver = driver;
	}
	
	protected WebElement getBySelector(String selector) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
	}
	
	protected WebElement getById(String id) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	protected WebElement getByName(String name) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}
	
	protected WebElement getByClassName(String className) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}


}
