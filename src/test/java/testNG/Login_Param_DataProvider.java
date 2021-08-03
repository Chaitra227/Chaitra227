package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Param_DataProvider {
	WebDriver driver;
  @BeforeTest
  public void setup() {
      System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.manage().window().maximize();
}

 //@Parameters({"username", "password"})
@Test(dataProvider="Logindata")
  public void login(String uname,String pwd) {
      driver.get("https://the-internet.herokuapp.com/login");
      driver.findElement(By.id("username")).sendKeys(uname);
      driver.findElement(By.id("password")).sendKeys(pwd);
}
  
@DataProvider(name="Logindata")
  public Object[][] getdata(){
	  return new Object[][] {
	  new Object[] {"admin", "admin"},
	  new Object[] {"admin1", "admin1"},
	  new Object[] {"tomsmith", "SuperSecretPassword!"},
	  
	  };
	  
  }
  
  @AfterTest
  public void close() {
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
      driver.close();
}
}
