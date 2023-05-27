package pruebas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5_E4 {
	
	WebDriver driver;
	String driverPath = "..\\EduIT\\Drivers\\chromedriver.exe";
	String urlTest ="http://demo.guru99.com/test/table.html";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(urlTest);
		driver.manage().window().maximize();
	}
	
	@Test
	public void verCelda() {
		WebElement celda = driver.findElement(By.xpath("//td[normalize-space()='8']"));
		Assert.assertEquals(celda.getText(), "8");

	}
	
	@AfterSuite
	public void  cerrar() {
	  driver.close();

	}

}
