package BookOrderPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ConfirmPurchase {
	
	
	 WebDriver driver;
		@Test
		public void LaunchApp()
		{
			System.setProperty("webdriver.chrome.driver", "D:\\October\\SeleniumLib\\GecoDriver\\chromedriver.exe");
			driver=new ChromeDriver();		
			driver.get("https://blazedemo.com/");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);		
			WebDriverWait wait = new WebDriverWait (driver, 100);		
			WebElement l=driver.findElement(By.xpath("//div/h1"));
			wait.until(ExpectedConditions.presenceOfElementLocated (By.cssSelector("h1")));
			System.out.println(l.getText());
			
			Select drpdown=new Select (driver.findElement(By.name("fromPort")));
			drpdown.selectByValue("Paris");		
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			System.out.println("Select drop down is Paris");
			Select drpdown2=new Select (driver.findElement(By.name("toPort")));
			drpdown2.selectByValue("London");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//WebDriverWait wait2 = new WebDriverWait (driver, 15);
			wait.until(ExpectedConditions.titleContains("Choose"));
			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("John");
			driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Pune");
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Maharashtra");
			driver.findElement(By.xpath("//input[@name='zipCode']")).sendKeys("411061");
			Select dropdown3=new Select(driver.findElement(By.name("cardType")));
			dropdown3.selectByValue("Visa");
			driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("123456789");
			driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("11");
			driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2017");
			driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("John");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			String Id=driver.findElement(By.cssSelector("body > div.container > div > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
			System.out.println("Id");
			
						
		}
		@Test
		public void quitapp()
		{
		 driver.quit();
		}


}
