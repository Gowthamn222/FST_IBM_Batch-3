
package suiteExample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 
{ WebDriver driver;

@BeforeClass(alwaysRun = true)
public void beforeClass()
{
	driver = new FirefoxDriver();
	driver.get("https://www.training-support.net/selenium/target-practice");
}
@Test (groups = {"HeaderTests", "ButtonTests"})
public void assertTitle() 
{
	  String title = driver.getTitle();
	  Assert.assertEquals("Target Practice",title);
	  System.out.println("Page title is: " + title);
}
  @Test (dependsOnMethods = {"assertTitle"}, groups = {"HeaderTests"})
  public void headerTest() 
  {
	  WebElement headerText = driver.findElement(By.cssSelector("h3#third-header"));
	  Assert.assertEquals("Third header", headerText.getText());
	  }
  
  @Test (dependsOnMethods = {"assertTitle"}, groups = {"HeaderTests"})
  public void headerColorTest() 
  {
	  
	  WebElement headerColor = driver.findElement(By.cssSelector("h3#third-header"));
	  Assert.assertEquals("rgb(251, 189, 8)", headerColor.getCssValue("color"));
  }
  @Test (dependsOnMethods = {"assertTitle"}, groups = {"ButtonTests"})
  public void buttonTest() 
  {
	  WebElement buttonText = driver.findElement(By.cssSelector("button.olive"));
	  Assert.assertEquals("Olive", buttonText.getText());
	  }
  
  @Test (dependsOnMethods = {"assertTitle"}, groups = {"ButtonTests"})
  public void buttonColorTest() 
  {
	  
	  WebElement buttonColor = driver.findElement(By.cssSelector("button.brown"));
	  Assert.assertEquals("rgb(255, 255, 255)", buttonColor.getCssValue("color"));
  }
 

  @AfterClass(alwaysRun = true)
  public void afterClass() 
  {
	  driver.close();
  }

}
