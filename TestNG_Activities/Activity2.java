package testNGTests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity2 

{ WebDriver driver;

@BeforeClass
public void beforeClass() 
{
	driver = new FirefoxDriver();
	driver.get("https://www.training-support.net/selenium/target-practice");
}


  @Test
  public void assertTitle() 
  {
	  String title = driver.getTitle();
	  Assert.assertEquals("Target Practice",title);
	  System.out.println("Page title is: " + title);
  }
  
  @Test
  public void findBlackButton() 
 
  {
	 Assert.assertNotNull(driver.findElement(By.id("BlackButton")));
	  
  }
  
  @Test (enabled= false)
  public void skippedTest() 
 
  {
	System.out.println(" This method is to be skipped");
	  
  }
 
  @Test 
  public void skippedTestViaException() 
  
  {
	  throw new SkipException(" This method is to be skipped Via Skip Exception");  

  }
  
  @AfterClass
  public void afterClass() 
  {
	  driver.close();
  }

}
