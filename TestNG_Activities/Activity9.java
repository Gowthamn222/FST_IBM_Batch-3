package suiteExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
	 @BeforeMethod
	  public void beforeMethod() 
	 {	Reporter.log("New Method: ");
		 driver.switchTo().defaultContent();
	  }
	 @BeforeTest
	  public void beforeTest() 
	 {
		 driver = new FirefoxDriver();
		 Reporter.log("Begin logging: ");
		 driver.get("https://www.training-support.net/selenium/javascript-alerts");
		 Reporter.log("URL opened ");
		 Reporter.log("Page Opened :"+driver.getTitle());
	  }
	 
	 
  @Test (priority = 1)
  public void simpleAlertTestCase() 
  {
	  Reporter.log("In Simple alert ");
	  driver.findElement(By.id("simple")).click();
	  Reporter.log("Alert Opened");
	  Alert a1 = driver.switchTo().alert();
	  Reporter.log("Switch to Alert ");
	  Assert.assertEquals(a1.getText(),"This is a JavaScript Alert!");
	  Reporter.log("verify alert text");
	  System.out.println("Alert Content:"+a1.getText());
	  Reporter.log("Print text to cinsole ");
	  a1.accept();
	  Reporter.log(" close alert ");
  }
  @Test (priority = 2)
  public void confirmAlertTestCase() 
  {
	  Reporter.log("In Confirm alert ");
	  driver.findElement(By.id("confirm")).click();
	  Reporter.log("Alert Opened");
	  Alert a2 = driver.switchTo().alert();
	  Reporter.log("Switch to Alert ");
	  Assert.assertEquals(a2.getText(),"This is a JavaScript Confirmation!");
	  Reporter.log("verify alert text");
	  System.out.println("Alert Content:"+a2.getText());
	  Reporter.log("Print text to cinsole ");
	  a2.accept();
	  Reporter.log(" close alert ");
  }
  @Test (priority = 3)
  public void promptAlertTestCase() {
	  
	  Reporter.log("In Prompt alert ");
	  driver.findElement(By.id("prompt")).click();
	  Reporter.log("Alert Opened");
	  Alert a3 = driver.switchTo().alert();
	  Reporter.log("Switch to Alert ");
	  Assert.assertEquals(a3.getText(),"This is a JavaScript Prompt!");
	  Reporter.log("verify alert text");
	  System.out.println("Alert Content:"+a3.getText());
	  Reporter.log("Print text to cinsole ");
	  a3.accept();
	  Reporter.log(" close alert ");
	  
  }
  @AfterTest
  public void afterTest() {
	  Reporter.log(" Ending Test ");
	  driver.close();
  }
}
