package AppiumActivity;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		   caps.setCapability("deviceId", "95aw85c7");
	        caps.setCapability("deviceName", "samsung SM-J810G");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.calculator");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
	}

	@Test
	public void multiply() {
		driver.findElementById("digit_3").click();
		driver.findElementById("op_mul").click();
		driver.findElementById("digit_7").click();
		driver.findElementById("eq").click();

		String result = driver.findElementById("result_final").getText();
		System.out.println(result);
		Assert.assertEquals(result, "21");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
