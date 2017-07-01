package utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class CommonDrivers {
	static String parentWindow=null;
	public static void switchToNewWindow(WebDriver driver) throws InterruptedException
	{
		parentWindow = driver.getWindowHandle();
		Thread.sleep(5000l);
		Set<String> windows= driver.getWindowHandles();
		for (String window : windows)
		{
			if (!window.equals(parentWindow))
			{
				driver.switchTo().window(window);
			}
		}
	}
	public static void switchToParentWindow(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000l);

		Set<String> windows= driver.getWindowHandles();
		for (String window : windows)
		{
				driver.switchTo().window(window);
		}
	}
	public String getProperty(String key)
	{
		File file = new File("./src/test/java/config/config.properties");
		Properties config =null;
		try
		{
		FileReader reader = new FileReader(file);
		config= new Properties();
		config.load(reader);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return config.getProperty(key);
	}
}
