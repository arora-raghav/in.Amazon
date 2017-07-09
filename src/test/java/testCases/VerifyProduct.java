package testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetails;
import pages.SearchResultsPage;
import testCore.Core;
import utils.CommonDrivers;
import utils.ExcelReader;

public class VerifyProduct extends Core{
	
	
	
	@Test(dataProvider="excelData")
	public void verifyPrice(String SNo, String productName, String productPrice, String productReview) throws InterruptedException
	{
		ProductDetails productDetails = null;
		try
		{
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		SearchResultsPage searchResultsPage =homePage.searchProduct(productName);
		productDetails = searchResultsPage.clickOnSearchedProduct();
		System.out.println(productDetails.getProductName());
		Assert.assertEquals(productDetails.getCountOfProductReviews(), productReview);
		Assert.assertEquals(productDetails.getProductPrice(), productPrice);
	}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			driver.close();
			CommonDrivers.switchToParentWindow(driver);
			
		}
	}

	@DataProvider
	public String[][] excelData() throws IOException
	{
		ExcelReader excelReader = new ExcelReader();
		return excelReader.read();
	}
	
}
