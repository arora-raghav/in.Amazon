package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {

	WebDriver driver;
	public WebDriver get(String browser)
	{
		try
		{
		
		if (browser.equalsIgnoreCase("firefox")||browser.equalsIgnoreCase("mozilla"))
		{
			System.setProperty("webdriver.gecko.driver", TestConfig.firefoxDriver);
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")||browser.equalsIgnoreCase("google"))
		{
			System.setProperty("webdriver.chrome.driver", TestConfig.chromeDriver);
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("ie")||browser.equalsIgnoreCase("internet"))
		{
			System.setProperty("webdriver.ie.driver", TestConfig.ieDriver);
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("No browser exists by this name");
		}
		
		}catch(Exception e)
		{
			System.out.println("Failed while initializing the browser");
		}
		return driver;
	}
}
