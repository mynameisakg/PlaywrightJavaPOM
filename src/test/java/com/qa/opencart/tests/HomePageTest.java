package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.contants.AppConstants;

public class HomePageTest extends BaseTest{
	
	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageUrlTest() {
		String actualUrl = homePage.getPageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("url").trim());
	}
	
	@DataProvider
	public Object[][] getProductData() {
		Object [][] obj = new Object[][] {
			
			{"MacBook"},
			{"iMac"},
			{"Samsung"}
			
		};
		return obj;
	}
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) {
		String actaulText = homePage.doSearch(productName);
		Assert.assertEquals(actaulText, "Search - " + productName);
	}
}
