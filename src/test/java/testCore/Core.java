package testCore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.Browsers;
import utils.CommonDrivers;

public class Core {

	public WebDriver driver=null;
	CommonDrivers commonDriver = new CommonDrivers();
	@BeforeSuite
	public void setUp()
	{
		Browsers browser = new Browsers();
		if (driver==null)
		{
			driver = browser.get(commonDriver.getProperty("browser"));
		}
		navigateToURL();
		setBrowserProperties();
	}
	public void navigateToURL()
	{
		try{
			driver.get(commonDriver.getProperty("URL"));
			}
		catch(Exception e)
		{
			System.out.println("Browser has been opened up however unable to navigate to URL" + commonDriver.getProperty("URL"));
			e.printStackTrace();
		}
	}
	public void setBrowserProperties()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60l, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
		{
			try
			{
//				driver.close();
				driver.quit();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
