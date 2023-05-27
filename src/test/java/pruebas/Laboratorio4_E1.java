package pruebas;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.paginaLogin;
import paginas.PaginaInicio;


public class Laboratorio4_E1 {
	

	WebDriver driver;
	paginaLogin login;
    PaginaInicio inicio;

	
	String driverPath="..\\EduIT\\Drivers\\chromedriver.exe";
	String url="http://automationpractice.pl/index.php?controller=authentication&back=my-account";
	
	
    @BeforeSuite
	public void setUp(){
    	System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
      }
    
    @AfterSuite
  	public void cierreNavegador(){
    	driver.close();
    }

    @BeforeMethod
	public void irASignIn() {
		inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
	}

    @Test
    public void irRegistroLogin() {
    	login = new paginaLogin(driver);
    	login.enterEmail("test1@gmail.com", "1234");
    	Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
    	
     }

    @Test
	public void crearCuentaInvalida() throws IOException {
		login = new paginaLogin(driver);
		login.enterEmail("correo@gmail.com", "");
		
		String texto = login.getTextTitleForm();
		Assert.assertEquals(texto, "AUTHENTICATION");
		
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EduIt\\Evidencias\\pantalla_crearCuentaInvalida.png"));
	}
 
}
