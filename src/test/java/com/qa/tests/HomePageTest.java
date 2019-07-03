package com.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SubHomePage;

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	SubHomePage subhomepage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage= new LoginPage();
		homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	  @Test (priority = 1) 
	  public void verifyHomePageTitleTest2()
	  { 
		  String actualtitle=homepage.VerifyHomeTitle();
		  Assert.assertEquals(actualtitle,"Exela HCM"); 
		  System.out.println("hi"); 
		  
	  }
	 
	
	  @Test (priority = 2) 
	  public void clickOnEmpRecordsTest() 
	  {
	   subhomepage =  homepage.clickOnEmpRecords();
	  
	  }
	 
	
	@Test (priority = 1)
	public void Testing() throws InterruptedException
	{

		Thread.sleep(5000);
		boolean logo=driver.findElement(By.xpath("/html/body/div[2]/header/a/span[2]/img")).isDisplayed();
		Assert.assertTrue(logo);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
