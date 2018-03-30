package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LoginPage extends Base {
	
	//Page Factory or Object Repositories(OR)
	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@FindBy(name="btnReset")
	WebElement resetButton;
	
	@FindBy(xpath="//h2[@class='barone']")
	WebElement bankName;
	
	@FindBy(xpath="//img[@role='presentation']")
	WebElement loginImage;
	
	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement verifyHomePageLanding;
	
	// Initialize the elements of OR
	public LoginPage() {
		PageFactory.initElements(driver, this); // this refers to the current class object
	}
	
	// All Actions 
	public String validateTitleOfThePage() {  // To get the Title of thePage
		return driver.getTitle();
	}
	
	public String validateBankNameOnThePage() {
		String bankNameClone= bankName.getText();
		return bankNameClone;
	}
	
	public Boolean validateLoginImage() {
		Boolean actualImage= loginImage.isDisplayed();
		return actualImage;
	}
	public HomePage validateLoginClick() { // Click Button Method
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.submit();
		return new HomePage();
	}

	public void resetClick() { // Reset Click 
		resetButton.submit();
	}
}
