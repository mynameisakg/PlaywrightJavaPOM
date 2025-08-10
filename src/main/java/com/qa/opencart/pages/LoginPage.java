package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage{
	
	private Page page;
	
	String userNameField = "input#input-email";
	String passwordField = "input#input-password";
	String forgotPasswordLink = "//input/following-sibling::a[text()='Forgotten Password']";
//	Locator forgottenPasswordLink = page.getByRole(AriaRole.LINK, 
//		    new Page.GetByRoleOptions().setName("Forgotten Password"));
	String loginButton = "//input[@type='submit']";
	String logoutLink = "//aside[@id='column-right']//a[text()='Logout']";
	
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public String getLoginPageTitle() {
		String pageTitle = page.title();
		System.out.println("Page title is : " + pageTitle);
		return pageTitle;
	}
	
	public boolean isForgotPassLinkVisible() {
		return page.isVisible(forgotPasswordLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App credentials are : " + appUserName + " || " + appPassword);
		page.fill(userNameField,appUserName);
		page.fill(passwordField, appPassword);
		page.click(loginButton);
		if(page.isVisible(logoutLink)) {
			System.out.println("User is logged in successfully!");
			return true;
		}
		return false;
	}

}
