package AppiumActivity;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "95aw85c7");
	        caps.setCapability("deviceName", "samsung SM-J810G");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", ".ui.ConversationListActivity");
		caps.setCapability("noReset", true);
		URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void smsTest() {
	
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Start chat\")")).click();
		String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
		driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("1234567890");
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Go"));
		String messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/hint_message\")";
		messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
		MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
		composeMessageInput.sendKeys("Hello from Appium");
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text")));
		String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
		String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
		Assert.assertEquals(sentMessageText, "Hello from Appium");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
