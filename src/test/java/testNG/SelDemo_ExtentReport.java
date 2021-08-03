package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SelDemo_ExtentReport {
	ExtentTest et;
	ExtentReports er;
	ExtentHtmlReporter hr;
	WebDriver driver;
	
	
	@BeforeTest
	public void Extentsetup() {
		hr=new ExtentHtmlReporter("C:\\SeleniumScreenshots\\TestReport.html"); 
//		hr.config().setDocumentTitle("");
//		hr.config().setReportName("");
		er=new ExtentReports();
		er.attachReporter(hr);
//		er.setSystemInfo(k, v);
		hr.setAppendExisting(true);
		
	}
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	}
  @Test
  public void chaitra() {
	  et=er.createTest("Search Chaitra");
	  driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
	  driver.findElement(By.id("user-message")).sendKeys("Chaitra");
	  driver.findElement(By.className("btn btn-default")).click();
  }
  
  @AfterMethod
  public void close(ITestResult ir) {
	  if(ITestResult.FAILURE == ir.getStatus()) {
		  System.out.println(ir.getName());
		  et.fail(ir.getName());
	  }
	  driver.close();
  }
	 
 
	@AfterTest
	public void flush() {
		er.flush();
	}
}
