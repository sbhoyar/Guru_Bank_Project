package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends Base {

	public LoginPage loginPageObject;
	public HomePage homePageObject;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
	}

	@Test(priority = 1)
	public void titleOfThePageTest() {
		String loginPageName = loginPageObject.validateTitleOfThePage();
		Assert.assertEquals(loginPageName, "GTPL Bank Home Page");
	}

	@Test(priority=2)
	public void validateBankNameOnThePageTest() {
	String bankNameTest= loginPageObject.validateBankNameOnThePage();
	Assert.assertEquals(bankNameTest, "Gtpl Bank");
	}
	
	@Test(priority=3)
	public void validateLoginImageTest() {
		Boolean image= loginPageObject.validateLoginImage();
		Assert.assertTrue(image);
	}
	
	@Test(priority=4)
	public void loginClickTest() {
	  homePageObject= loginPageObject.validateLoginClick();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
