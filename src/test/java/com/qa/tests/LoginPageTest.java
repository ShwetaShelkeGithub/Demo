package com.qa.tests;

import org.apache.log4j.Priority;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super(); //calling TestBase class constructor
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization(); //calling TestBase class initialization method
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyTitle()
	{
		String title=loginpage.loginPageTitle();
		Assert.assertEquals(title, "Exela HCM");
	}
	
	/*
	 * @Test(priority=2) public void verifyUsernameandPassword() { String
	 * username=prop.getProperty("username"); String
	 * password=prop.getProperty("password");
	 * 
	 * Assert.assertEquals(username, "972718"); Assert.assertEquals(password,
	 * "Welcome123");
	 * 
	 * }
	 */		
	@Test(priority=2)
	public void loginTest() throws InterruptedException
	{
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
