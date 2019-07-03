package com.qa.tests;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HRPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SubHomePage;

public class HRPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	SubHomePage subhomepage;
	HRPage hrpage; 
	
	public HRPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnEmpRecords();
		subhomepage = new SubHomePage();
		subhomepage.ClickHRLink();
		hrpage = new HRPage();
	}
	
	
	/*
	@Test
	public void countTotalLinksTest()
	{
		System.out.println("hi..");
		hrpage.countTotalLinks();
	}*/
	
	@Test
	public void ClickAddEMpTest() throws InterruptedException, AWTException
	{
		hrpage.AddEmp();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}

