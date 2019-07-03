package com.qa.tests;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HRPage;
import com.qa.pages.HRPageDataDriven;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SubHomePage;
import com.qa.util.TestUtil;

public class HRPageDataDrivenTest extends TestBase
{


	LoginPage loginpage;
	HomePage homepage;
	SubHomePage subhomepage;
	HRPageDataDriven hrpageDD;
	
	String sheetName="Sheet1";
	
	
	public HRPageDataDrivenTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnEmpRecords();
		subhomepage = new SubHomePage();
		subhomepage.ClickHRLink();
		hrpageDD = new HRPageDataDriven();
	}
	
	@DataProvider
	public Object[][] getHCMEmpTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider="getHCMEmpTestData")
	public void CreateEmpTest(String firstname, String lastname, String knownAs, String emailid, String gender, String workph, String homeph, String workMob, String sin) throws InterruptedException, AWTException
	{
		hrpageDD.AddEmpClick();
	//	hrpageDD.CreateEmp("firstname", "lastname", "knownAs", "emailid@test.com", "Male", "1244568544", "2235674415", "5568554252", "7", "554265748");
		
		hrpageDD.CreateEmp(firstname, lastname, knownAs, emailid, gender, workph, homeph, workMob, sin);
	}
	
	

	
	@AfterMethod
	public void tesrdown()
	{
		driver.close();
	}
}
