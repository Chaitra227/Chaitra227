package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class Google_Priority_RetryLogic {
  WebDriver driver;
  
  
  @BeforeMethod
  public void setup() {
         System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.manage().window().maximize();
  }
  
  //@Test(retryAnalyzer=RetryAnalyzerTest.class)
  public void Selsearch() {      
      driver.get("https://www.google.com");
      WebElement searchBox= driver.findElement(By.name("q"));
      searchBox.sendKeys("Selenium");
      searchBox.submit();
      Assert.assertEquals("Selenium - Google Searc",driver.getTitle());
}
  
  @Test(priority=1)
  public void Javasearch() {      
      driver.get("https://www.google.com");
      WebElement searchBox= driver.findElement(By.name("q"));
      searchBox.sendKeys("Java");
      searchBox.submit();
      Assert.assertEquals("Java - Google Search",driver.getTitle());
}
  
  @Test(priority=1)
  public void Cypresssearch() {      
      driver.get("https://www.google.com");
      WebElement searchBox= driver.findElement(By.name("q"));
      searchBox.sendKeys("Cypress");
      searchBox.submit();
      Assert.assertEquals("Cypress - Google Search",driver.getTitle());
}
  
  @AfterMethod
  public void close() {
	  driver.close();
  }
  
  
}
