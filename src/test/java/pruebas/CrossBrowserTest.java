package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {
	WebDriver driver;
	String url="http://automationpractice.pl/index.php";
	String driverPath="..\\EduIT\\Drivers\\chromedriver.exe";
	String driverPathF="..\\EduIT\\Drivers\\geckodriver.exe";

	@BeforeMethod
    @Parameters("navegador")
	public void setUp(String navegador) {	
		if (navegador.equalsIgnoreCase("chrome")) {		
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			driver= new ChromeDriver(options);
			
		}
		else {
			System.setProperty("webdriver.gecko.driver", driverPathF);
			driver= new FirefoxDriver();
		
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	
	 }
	@Test
	public void buscarPalabra() {
        WebElement txtBuscador = driver.findElement(By.name("search_query"));
		
		txtBuscador.clear();
		txtBuscador.sendKeys("Blouse");
		txtBuscador.sendKeys(Keys.ENTER);	
	}
	
	@AfterMethod
	public void cierraNavegador() {
		driver.quit();

	}
}

