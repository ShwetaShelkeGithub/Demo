package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class SubHomePage extends TestBase{
	
		@FindBy(xpath="//*[@id=\'HumanResources_UnderTab\']/span")
	  WebElement HumanResource;
	
	  @FindBy(xpath="//*[@id=\'MyProfile_GrandChildMenu\']/li[1]/a")
	  WebElement ViewProfilelink;
	  
	  @FindBy(xpath= "/html/body/div[1]/div[1]/div[1]/section/div/div[2]/div[1]")
	  WebElement EmpName;
	  
	  @FindBy(xpath="//ul[@id='EmployeeDetails_GrandChildMenu'] //a[@id='myEmpProfileLink' and text()='Employee Search'] ")
	  WebElement EmployeeSearch;
	  
	  @FindBy(xpath="//input[@id='txtEmployeeCode']") 
	  WebElement EnterEmpId;
	  
	  @FindBy (xpath="//button[@value='Submit1']") 
	  WebElement SubmitButton;
	  
	  @FindBy (xpath="//table[@id='tblSearch']//tr//td[1]")
	  WebElement SearchEmplResult;
	 
	  @FindBy (xpath="//*[@id=\'tablst\']/li[2]/a/span/span")
	  WebElement EmpDetailsLink;
	
	//Initializing the Page Objects
	
	 public SubHomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String VerifySubHomeTitle()
	{
		return driver.getTitle();
	}
	
	
	  public void ClickViewProfileLink() throws InterruptedException 
	  {
	  ViewProfilelink.click();
	  
	  }
	  
	  public String VerifyEMpName() 
	  { 
		  String emp1=EmpName.getText();
		  System.out.println(emp1);
		  String[] str1=emp1.split(":");
		  System.out.println("value is :"+str1[1]);
		  System.out.println("testing");
		  String[] empname= str1[1].split("\\(");
		  System.out.println("firstname  is :"+empname[0]);
		// System.out.println(str2[1]+" "+str2[2]);
		//  String empname= str2[1]+" "+str2[2];
		  return empname[0];
		  
	  }
	  	
	
	  public String SearchEmpl() 
	  {
		  HumanResource.click();
		  EmployeeSearch.click();
	  EnterEmpId.sendKeys("993193");
	  SubmitButton.click(); 
	  String abc=SearchEmplResult.getText();
	  return abc;
	  }
	  
	  public String SearchEmplResult()
	  { 
		  String result = SearchEmplResult.getText();
		  return result;
		  
	  }
	  
	  public HRPage ClickHRLink()
	  {
		  HumanResource.click();
		  return new HRPage();
	  }
	 
}
