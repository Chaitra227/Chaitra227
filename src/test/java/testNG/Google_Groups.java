package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Google_Groups {
    WebDriver driver;
    
    @BeforeGroups("featureOne")
    public void setup() {
           System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           driver.manage().window().maximize();
    }
    @BeforeGroups("featureTwo")
    public void setup1() {
           System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           driver.manage().window().maximize();
    }
           
    @Test
          public void searchTest() {
           
                  driver.get("https://www.google.com");
                  WebElement searchBox= driver.findElement(By.name("q"));
                  searchBox.sendKeys("selenium");
                  searchBox.submit();
                  Assert.assertEquals("Selenium - Google Search",driver.getTitle());
    }
    
     @Test(groups="featureOne")
          public void cypressTest() {
                 driver.get("https://www.google.com");
                 WebElement searchBox= driver.findElement(By.name("q"));
                  searchBox.sendKeys("cypress");
                  searchBox.submit();
                  Assert.assertEquals("cypress - Google Search", driver.getTitle());
    }
    @Test(groups="featureOne")
          public void javaTest() {
           driver.get("https://www.google.com");
           
                 WebElement searchBox= driver.findElement(By.name("q"));
                  searchBox.sendKeys("java");
                  searchBox.submit();
                  Assert.assertEquals("java - Google Search", driver.getTitle());
                  
           }
    
    @Test(groups="featureTwo",invocationCount=4)
    public void seleniumTest() {
     driver.get("https://www.google.com");
     Assert.assertEquals("Google", driver.getTitle());
           WebElement searchBox= driver.findElement(By.name("q"));
            searchBox.sendKeys("selenium");
            searchBox.submit();
            System.out.println("Selenium");
            //Assert.assertEquals("selenium - Google Search", driver.getTitle());
            
     }
    
    
    @AfterGroups("featureOne")
    public void close() {
           driver.close();
    }
    
    @AfterGroups("featureTwo")
    public void close1() {
           driver.close();
    }
          
    }
