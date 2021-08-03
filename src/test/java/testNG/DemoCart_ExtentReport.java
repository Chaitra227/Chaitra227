package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import commonUtils.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoCart_ExtentReport {
	ExtentTest extentTest;
	ExtentReports reports;
	ExtentHtmlReporter htmlreport;
    WebDriver driver;
    
    @BeforeTest
    public void extentsetup() {
    	reports = new ExtentReports();
    	htmlreport = new ExtentHtmlReporter("C:\\SeleniumScreenshots\\ExtntReport.html");
    	reports.attachReporter(htmlreport);
    	htmlreport.setAppendExisting(true);
    }
    
    @BeforeMethod
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

  @Test
  public void SearchPhone() {
      	extentTest=reports.createTest("Search Phone");
        driver.get("https://demo.opencart.com/");
        driver.findElement(By.name("search")).sendKeys("Phone");;
        WebElement btn= driver.findElement(By.className("input-group-btn"));
        btn.click();
  }
  
  @Test
  public void SearchDesktop() {
      	extentTest=reports.createTest("Search Desktop");
        driver.get("https://demo.opencart.com/");
        driver.findElement(By.name("search")).sendKeys("Desktop");;
        WebElement btn= driver.findElement(By.className("input-group-btn"));
        btn.click();
        Assert.assertEquals("Searc-Desktop", driver.getTitle());
  }
  @AfterMethod
  public void close(ITestResult result) throws IOException {
	  if(ITestResult.FAILURE==result.getStatus()) {
		  extentTest.fail(result.getName());
		  String screenshotpath = Utility.getScreenshot(driver);
		  extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
	  }
	  driver.close();	  
  }
  
  @AfterTest
  public void flush() {
	  reports.flush();
  }
}
