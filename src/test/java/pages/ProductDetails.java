package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDetails {

	public WebDriver driver;
	public ProductDetails(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy(xpath="//*[@id='title']")
	WebElement productName;
	
	@FindBy(xpath="//*[@id='acrCustomerReviewText']")
	WebElement countOfProductReviews;
	
	@FindAll({
		   @FindBy(xpath="//*[@id='priceblock_ourprice']"),
		   @FindBy(xpath="//*[@id='priceblock_saleprice']")
		})
	WebElement productPrice;
	
	@FindBy(xpath="//*[@id='native_dropdown_selected_size_name']")
	WebElement productSize;
	
	public String getProductName()
	{
		return productName.getText();
	}
	public String getCountOfProductReviews()
	{
		String countOfReviews =  countOfProductReviews.getText().split(" ")[0];
		return countOfReviews;
	}
	public String getProductPrice()
	{
		return productPrice.getText();
	}
	public String[] getSizeList()
	{
		Select select = new Select(productSize);
		List<WebElement> list = select.getOptions();
		String [] productSizes = new String[list.size()];
		for (int i=0;i<list.size();i++)
		{
			productSizes[i]=list.get(i).getText();
		}
		return productSizes;
	}
}
