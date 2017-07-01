package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement searchBox;
	@FindBy(xpath="//*[@id='nav-search']/form/div[2]/div/input")
	WebElement searchButton;
	@FindBy(xpath="//*[@id='nav-link-shopall']")
	WebElement categories;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public SearchResultsPage searchProduct(String productName)
	{
		try
		{
			searchBox.clear();
			searchBox.sendKeys(productName);
			searchButton.click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, SearchResultsPage.class);
	}
	
}
