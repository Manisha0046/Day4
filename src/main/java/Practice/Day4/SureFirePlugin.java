package Practice.Day4;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SureFirePlugin {

	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	
	@Test(groups= { "Testing" })
	public void BrokenLinks()
	{
		driver.get("http://demo.guru99.com/test/newtours/");
		List<WebElement> list= driver.findElements(By.tagName("a"));
		Iterator<WebElement> it=list.iterator();
		while(it.hasNext())
		{
			String link=it.next().getAttribute("href");
			Links(link);
		}
	}
	
	public void Links(String link)
	{
		URL url;
		try {
			url = new URL(link);
			HttpURLConnection connection=null;
			connection=(HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();
			if(connection.getResponseCode()==200)
			{
				System.out.println(url+"===> "+connection.getResponseCode());
			}
			else if(connection.getResponseCode()>=404)
			{
				System.out.println(url+"===> "+connection.getResponseCode());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.close();
	}
	
}
