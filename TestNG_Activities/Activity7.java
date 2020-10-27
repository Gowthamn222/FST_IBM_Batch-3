package suiteExample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity7 
{WebDriver driver;

@BeforeClass(alwaysRun = true)
public void beforeClass()
{
	driver = new FirefoxDriver();
	driver.get("https://www.training-support.net/selenium/login-form");
}
	@DataProvider(name = "Authentication")
	public static Object[][] credentials()
	{
		return new Object[][] {{"admin","password"}};
		
	}
  @Test (dataProvider = "Authentication")
  public void testDataProvider(String username, String password) 
  
  {
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
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

