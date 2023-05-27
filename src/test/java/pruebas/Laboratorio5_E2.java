package pruebas;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class Laboratorio5_E2 {
	
	WebDriver driver;

	
	String driverPath="..\\EduIT\\Drivers\\chromedriver.exe";
	String url="https://demo.guru99.com/test/upload/";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
  
   @AfterSuite
	public void finSuite() {
        driver.close();
	}
	
	@Test()
	public void cargarArchivo() {
		WebElement rutaACargar = driver.findElement(By.id("uploadfile_0"));
		File f = new File("pruebas.txt");
        rutaACargar.sendKeys(f.getAbsolutePath());
	 
	}



}
