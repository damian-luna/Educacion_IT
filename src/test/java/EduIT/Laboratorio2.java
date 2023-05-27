package EduIT;

import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Laboratorio2 {
	@Test
	public void lab2_E1Test () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");
    	ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
		
		WebElement txtEmail= driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo"+ Math.random()+"@correo.com");
		WebElement btnCreate= driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();
		
		//Thread.sleep(3000);
		WebElement btnGender;
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    btnGender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( "id_gender1")));
	    btnGender = driver.findElement(By.id( "id_gender1"));
	    btnGender.click();
	    
		WebElement txtCustomerName= driver.findElement(By.name("customer_firstname"));
		txtCustomerName.sendKeys("Juan Perez");
		
		WebElement txtPassword= driver.findElement(By.id("passwd"));
		txtPassword.sendKeys("Pass1234");
		
		Select drpMonths= new Select(driver.findElement(By.id("months")));
		drpMonths.selectByValue("4");
		
		WebElement btnRegister= driver.findElement(By.xpath("//*[contains(text(),\"Register\")]"));
		btnRegister.click();
		
		Assert.assertEquals("http://automationpractice.pl/index.php?controller=authentication", driver.getCurrentUrl());
	}
}
