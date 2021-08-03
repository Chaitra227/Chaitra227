package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoPage {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	}
	
	@Test
	public void Democart() {
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Register')]")).click();
	}
		
		@Test
		public void Register() {
		driver.findElement(By.id("input-firstname")).sendKeys("test");
		driver.findElement(By.id("input-lastname")).sendKeys("test");
		driver.findElement(By.id("input-email")).sendKeys("d123@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("8765498765");
		driver.findElement(By.id("input-password")).sendKeys("test123");
		driver.findElement(By.id("input-confirm")).sendKeys("test123");
		//int a=driver.findElements(By.xpath("//input[@name='newsletter']")).size();
		driver.findElements(By.xpath("//input[@name='newsletter']")).get(0).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals("Your Account Has Been Created!", driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();		
  }
		@Test
		public void Search() throws InterruptedException {
			driver.findElement(By.name("search")).sendKeys("Phone");
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Shopping Cart')]")).click();
			Assert.assertEquals("Shopping Cart", driver.getTitle());
			driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			Thread.sleep(10000);
			driver.close();
		}
}
