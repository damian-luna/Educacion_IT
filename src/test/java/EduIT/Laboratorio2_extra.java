package EduIT;

import java.time.Duration;

import org.junit.*; 
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Laboratorio2_extra {
	
   
	@Test
	public void lab2_E1Test() {
		  
		  String url="http://automationpractice.pl/index.php?controller=authentication#account-creation";
		
		   System.setProperty("webdriver.chrome.driver", "..\\EducacionIT\\Drivers\\chromedriver.exe");
		    ChromeOptions options=new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			
			WebDriver driver= new ChromeDriver(options);	
			
			driver.get(url);
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
		
		   
		   
		   WebElement txtEmail=driver.findElement(By.id("email_create"));
		   txtEmail.sendKeys("micorreo"+ Math.random()+"@correo.com");
		   
		   
		   WebElement btnCreate=driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
		   
		   
		   btnCreate.click();
		   
		   //g)
		   WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		   mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));
		   
		   driver.findElement(By.id("id_gender1")).click();
		   
			//c)
			driver.findElement(By.name("customer_firstname")).sendKeys("Juan Torres"); 
			
			//d)
			driver.findElement(By.name("passwd")).sendKeys("123456"); 
			
			//e)
			
			Select months= new Select(driver.findElement(By.id("months")));
			
			months.selectByValue("4");
			//h)
			driver.findElement(By.xpath("//*[text()='Register']")).click();
			
			
			Assert.assertEquals("http://automationpractice.pl/index.php?controller=authentication", driver.getCurrentUrl());
			//driver.close();
			
		   

		   
		
	
	}
	
	

}
