package pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorApp {
	private AppiumDriver<MobileElement> driver;
	
	public CalculatorApp() {

		try {
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "1.0.0.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone64_x86_64");
			caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			caps.setCapability("appPackage", "com.android.calculator2");
			caps.setCapability("appActivity", ".Calculator");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			this.driver = new AppiumDriver<MobileElement>(url, caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MobileElement getButtonOne() {
		return driver.findElementById("com.android.calculator2:id/digit_1");
	}
	public MobileElement getButtonTwo() {
		return driver.findElementById("com.android.calculator2:id/digit_2");
	}
	public MobileElement getButtonSum() {
		return driver.findElementById("com.android.calculator2:id/op_add");
	}
	public MobileElement getButtonEqual() {
		return driver.findElementById("com.android.calculator2:id/eq");
	}
}
