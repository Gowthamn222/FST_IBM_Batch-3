package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Activity3 {
	
	WebDriver driver;

	@BeforeClass
	public void beforeClass()
	{
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}
  @Test
  public void f()
  {
	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("password");
	  driver.findElement(By.cssSelector("button[onclick=\'signIn()\']")).click();
	  String loginMsg = driver.findElement(By.id("action-confirmation")).getText();
	  Assert.assertEquals("Welcome Back, admin",loginMsg);
	  System.out.println(loginMsg);
	
  }


  @AfterClass
  public void afterClass()
  {
	  driver.close();
  }


}
