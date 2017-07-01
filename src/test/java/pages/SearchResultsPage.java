package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonDrivers;

public class SearchResultsPage {

	@FindBy(xpath="//*[@id='s-result-count']")
	WebElement resultCount;
	
	@FindBy(xpath="//*[@id='result_0']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span[2]")
	WebElement productPrice;
	
	@FindBy(xpath="//*[@id='result_0']/div/div/div/div[2]/div[2]/div[2]/div[1]/a")
	WebElement countOfProductReviews;
	
	@FindBy(xpath="//*[@id='s-result-count']/span/span")
	WebElement productName;
	
	@FindBy(xpath="(//li[@id='result_0'])[1]//h2/..")
	WebElement productLink;
	
	WebDriver driver;
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// will click on the first product appears on the result page
	public ProductDetails clickOnSearchedProduct()
	{
		
		try
		{
			Thread.sleep(3000l);
			productLink.click();
			CommonDrivers.switchToNewWindow(driver);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, ProductDetails.class);
	}
	
	public String getNumberOfSearchResults()
	{
		String totalNumberOfResults = null;
		try
		{
			String resultText = resultCount.getText();
			totalNumberOfResults = resultText.split(" ")[0];
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return totalNumberOfResults;
	}
	public String getSearchedProductName()
	{
		return productName.getText();
	}
	public String getFirstProductPrice()
	{
		return productPrice.getText();
	}
	public String getCountOfProductReviews()
	{
		return countOfProductReviews.getText();
	}
}
