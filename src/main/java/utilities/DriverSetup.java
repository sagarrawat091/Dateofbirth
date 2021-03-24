package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	private static WebDriver driver;

	public static WebDriver getWebDriver(String browser)
	{
		//getting Chrome browser
			if(browser.equalsIgnoreCase("chrome"))
			{
				 WebDriverManager.chromedriver().arch64().setup();
				 driver=new ChromeDriver();
			}
			//getting the edge browser
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().arch64().setup();
				driver=new EdgeDriver();
			}
			//getting firefox browser
			else if(browser.equalsIgnoreCase("firefox"))
			{	
				WebDriverManager.firefoxdriver().arch64().setup();
				driver=new FirefoxDriver();
			}
			//invalid browser
			else
			{
				System.err.println("browser : " + browser + " is invalid");
			}	
		// return the driver
	return driver;

}

}
