package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public Base() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					"/Users/sonalikarde/eclipse-workspace/Guru99BankProject/src/main/java/com/qa/config/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void initialization() {

		System.setProperty("webdriver.chrome.driver", "/Users/sonalikarde/Documents/SeleniumSupporters/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_LoadT_imeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V1/index.php");
	}
}
