package com.qa.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends Base {
	
	HomePage homePageObject;
	LoginPage loginPageObject;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePageObject = new HomePage();
		loginPageObject = new LoginPage();
		homePageObject =loginPageObject.validateLoginClick();
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest() {
		String homePageTitle= homePageObject.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "GTPL Bank Manager HomePage");
	}
	
	@Test(priority=2)
	public void marqueeTextCheckTest() {
	  Boolean marqueCheck= homePageObject.marqueeTextCheck();	
	  Assert.assertTrue(marqueCheck);
	}
	
	@Test(priority=3)
	public void threeImageDisplayCheckTest() {
		List<Boolean> listImage = homePageObject.threeImageDisplayCheck();
		Assert.assertTrue(listImage.containsAll(listImage));
	}
	
	@Test(priority=4)
	public void verifyManagerClickTest() {
		homePageObject.verifyManagerClick();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
