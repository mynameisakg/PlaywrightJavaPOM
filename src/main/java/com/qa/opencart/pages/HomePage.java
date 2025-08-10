package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	String searchField = "div#search input";
	String searchButton = "div#search button";
	String searchResultHeaderText = "div#content h1";
	String loginLink = "a:text('Login')";
	String myAccountDropDown = "//a[@title='My Account']";
	
	public HomePage(Page page) {
		this.page = page;
	}
	
	public String getHomePageTitle() {
		String pageTitle = page.title();
		System.out.println("Page title is : " + pageTitle);
		return pageTitle;
	}
	
	public String getPageUrl() {
		String pageUrl = page.url();
		System.out.println("Pgae Url is : " + pageUrl);
		return pageUrl;
	}
	
	public String doSearch(String product) {
		page.fill(searchField, product);
		page.click(searchButton);
		String searchHeader = page.textContent(searchResultHeaderText);
		System.out.println("The search header is : " + searchHeader);
		return searchHeader;
	}
	
	public LoginPage navigateToLoginPage() {
		page.locator(myAccountDropDown).click();
		page.locator(loginLink).click();
		return new LoginPage(page);
	}

}
