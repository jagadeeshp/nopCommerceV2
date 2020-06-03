package com.nopcommerce.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		
		logger.info("URL is opened...");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User provided");
		lp.setPasssword(password);
		logger.info("Password provided");
		lp.clickLogin();
		logger.info("Login is clicked");
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed");
		}
	}
		
	
	

}
