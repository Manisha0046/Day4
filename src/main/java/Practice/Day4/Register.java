package Practice.Day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register {

	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	@Test(alwaysRun=true,groups = { "Testing" })
	public void Register()
	{
		driver.get("http://demo.guru99.com/test/newtours/");

		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Manisha");
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Patil");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("7703156338");
		driver.findElement(By.cssSelector("input#userName")).sendKeys("manishapatil159@gmail.com");
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Banner");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Pune");
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Maharashtra");
		driver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys("422006");
		
		WebElement element=driver.findElement(By.cssSelector("select[name='country']"));
		Select country=new Select(element);
		country.selectByValue("INDIA");
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("manishapatil159@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123...aa");
		driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("123...aa");
		
		WebElement button=driver.findElement(By.name("submit"));
		JavascriptExecutor JS=(JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();",button);
		
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}

}
