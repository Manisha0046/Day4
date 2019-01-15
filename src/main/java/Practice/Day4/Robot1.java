package Practice.Day4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Robot1 {


		public static WebDriver driver;
		@BeforeMethod
		 public void BeforeMethod1() 
		 {
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

			driver=new ChromeDriver();
			 driver.get("http://demo.guru99.com/test/upload/");
			 driver.manage().window().maximize();
			 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 }
		
		@Test
		public void upload() throws AWTException
		{
			StringSelection str=new StringSelection("I:\\OrangeHRM\\Day4\\src\\main\\java\\Practice\\Day4\\Write.java");
			Toolkit tool=Toolkit.getDefaultToolkit();
			Clipboard board=tool.getSystemClipboard();
			board.setContents(str,null);
			
			Robot robot=new Robot();
			driver.findElement(By.xpath("//input[@name='uploadfile_0']")).click();
			robot.delay(150);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(150);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			
		}
		
		
		@AfterMethod	
		public void AfterMethod1()
		{
			driver.close();
		}
	

}
