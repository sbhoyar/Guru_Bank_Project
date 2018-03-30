package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class HomePage extends Base {

	HomePage homePageObject;
	
	// Page Factory
	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement marqueeText;
	
	@FindBy(xpath="//*[@href='Managerhomepage.php']")
	WebElement managerBtnclick;
	
	// Page Factory Initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// To validate the Title of the Home Page
	public String validateHomePageTitle() {
		String homePageTitle= driver.getTitle();
		return homePageTitle;
	}
	
	// To validate the text displayed in between the Home page
	public Boolean marqueeTextCheck() {
		Boolean marqueeTextCheck =marqueeText.isDisplayed();
		return marqueeTextCheck;
	}
	
	public List<Boolean> threeImageDisplayCheck() {
		List<Boolean> listBoolean = new ArrayList<Boolean>();
		List<WebElement> imageList = driver.findElements(By.xpath("//img[contains(@src, '../images/')]"));
	    for(int i=0; i<imageList.size(); i++) {
	     Boolean imageResult=imageList.get(i).isDisplayed();
	      listBoolean.add(imageResult);
	    }
	    return listBoolean;
	}
	
	public HomePage verifyManagerClick() {
		managerBtnclick.click();
		return new HomePage();
	}
	
}
