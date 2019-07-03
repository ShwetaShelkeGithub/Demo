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

public class SubHomePageTest extends TestBase
{

	LoginPage loginpage;
	HomePage homepage;
	SubHomePage subhomepage;
	
	public SubHomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException
	{
		initialization();
		loginpage = new LoginPage();
		homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnEmpRecords();
		subhomepage = new SubHomePage();
	}
	
	@Test (priority=1)
	public void VerifyHomeTitleTest() throws InterruptedException
	{
		String t= subhomepage.VerifySubHomeTitle();
		Assert.assertEquals(t,"Exela HCM","SubHome Title not matching");
	}
	
	
	  @Test (priority=3) 
	  public void VerifyViewProfileTest() throws InterruptedException 
	  { 
		  subhomepage.ClickViewProfileLink(); 
		  String  actualempname= subhomepage.VerifyEMpName();
		  
		  Assert.assertEquals(actualempname, " Yuvraj Singh ","Emp Name is not matching"); 	 
	  }
	
	
	  @Test (priority=4)
	  public void ClickHRTest() throws InterruptedException
	  {
	   subhomepage.ClickHRLink();
	  }
	  
	
	 
	  	  
	  @Test (priority=2) 
	  public void SearchEmpTest() throws InterruptedException 
	  {
	 // subhomepage.ClickHR();
	  subhomepage.SearchEmpl(); 
	  String Actualresult =subhomepage.SearchEmplResult();
	  
	  Assert.assertEquals(Actualresult, "993193");
	  }
	  
	/*
	 * @Test (priority=3) public void ClickEmpDetalisLinkTest() {
	 * subhomepage.ClickEmpDetailsLink(); }
	 */
	 
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
