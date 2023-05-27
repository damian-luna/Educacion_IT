package EduIT;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Laboratorio1 {
	
	@Test @Ignore
	public void lab1_test() {
		System.out.println("hola mundo de automatizacion");
	}
	
	@Test @Ignore
	public void lab1_E1() {
		System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.navigate().to("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		driver.close();	
	}
	
	@Test @Ignore
	public void lab1_E2() {
		System.setProperty("webdriver.gecko.driver", "..\\EduIT\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); 
		driver.navigate().to("http://automationpractice.pl/index.php");
		driver.close();	
	}

	@Test 
	public void lab1_e3() {
		System.setProperty("webdriver.chrome.driver", "..\\EduIt\\Drivers\\chromedriver.exe");
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		
		//WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		WebElement txtBuscador = driver.findElement(By.name("search_query"));
		
		txtBuscador.clear();
		txtBuscador.sendKeys("Blouse");
		txtBuscador.sendKeys(Keys.ENTER);	
		
		driver.close();
	}
	
	@Test @Ignore
	public void lab1_e1() {
		System.setProperty("webdriver.chrome.driver", "..\\EduIt\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.saucedemo.com/");
	
		// Login
		WebElement txtUsername = driver.findElement(By.id("user-name"));
		txtUsername.sendKeys("standard_user");
		
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("secret_sauce");
		
		WebElement btnLogin = driver.findElement(By.id("login-button"));
		btnLogin.click();
	}

}
