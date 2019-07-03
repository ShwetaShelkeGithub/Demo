package com.qa.pages;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.stylesheets.LinkStyle;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HRPageDataDriven extends TestBase{

	@FindBy(xpath="//ul[@id='EmployeeDetails_GrandChildMenu']//a[@id='myEmpProfileLink']")
	WebElement EmpSearchLink;
	
	
	@FindBy(xpath="//ul[@id='EmployeeDetails_GrandChildMenu']//a[text()=' Add Employee ']")
	WebElement AddEmp;
	
	
	@FindBy(xpath="//input[@class='select-dropdown']")
	WebElement Selectcountry;
	
	@FindBy(xpath="//span[text()='Canada']")
	WebElement Canadacountry;
	
	@FindBy(xpath="//button[@id='btnPopUpSubmit']")
	WebElement SubmitCountrybutton;
	
	
	@FindBy(xpath="//input[@id='txtFirstName']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='txtLastName']")
	WebElement LastName;

	@FindBy(xpath="//input[@id='txtKnownAs']")
	WebElement KnownAs;
	
	@FindBy(xpath="//input[@id='txtWorkEmail']")
	WebElement WorkEmail;
	
	@FindBy(xpath="//input[@id='txtDOB']")
	WebElement dateofBirth;
	
	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='datepicker-switch']")
	WebElement dobMidClick;
	
	@FindBy(xpath="//div[@class='datepicker-months']//th[text()='«']")
	WebElement dobclickprev;
	
	@FindBy(xpath="//div[@class='datepicker-months']//th[text()='»']")
	WebElement dobclicknext;
	
	/*
	@FindBy(xpath="")
	WebElement ;
	
	@FindBy(xpath="")
	WebElement ;
	*/
	
	@FindBy(xpath="//select[@id='ddlGender']")
	WebElement selectGender;
	
	@FindBy(xpath="//input[@id='txtWorkPhone']")
	WebElement workPhone;
	
	@FindBy(xpath="//input[@id='txtHomePhone']")
	WebElement homePhone;
	
	@FindBy(xpath="//input[@id='PrivateMobileNumber']")
	WebElement workMobile;
	
	@FindBy(xpath="//select[@id='ddlMaritalStatus']")
	WebElement SelectmaritalStatus;
	
	@FindBy(xpath="//input[@id='txtSINValue']")
	WebElement SIN;
	
	
	public HRPageDataDriven()
	{
		PageFactory.initElements(driver, this);
	}
	

	public void AddEmpClick() throws InterruptedException, AWTException
	{
		AddEmp.click();
		Thread.sleep(3000);
		Selectcountry.click();
		//Thread.sleep(3000);
		//WebElement clickCanadacountry = wait.until(ExpectedConditions.visibilityOfElementLocated((By) Canadacountry));
		//implictWait();
		Thread.sleep(3000);
		Canadacountry.click();
		Thread.sleep(3000);
		SubmitCountrybutton.click();
		//implictWait();
		
	}
	public void CreateEmp(String firstname, String lastname, String knownAs, String emailid, String gender, String workph, String homeph, String workMob, String sin) throws InterruptedException
	{	
	FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		KnownAs.sendKeys(knownAs);
		WorkEmail.sendKeys(emailid);
		
		Thread.sleep(3000);
		//dateofBirth.click();
		//Thread.sleep(3000);
	
		/*
		//Split the date time to get only the date part
		
		String DOB="09/16/1997";
		String Date[]= DOB.split("/");
		
		//get the year difference between current year and year to set in calendar
		int yearDiff = Integer.parseInt(Date[2])- Calendar.getInstance().get(Calendar.YEAR);
		
		dobMidClick.click();
		
		Thread.sleep(3000);
        System.out.println("Year Diff is->"+ yearDiff);
		if(yearDiff!=0)
		{
			if(yearDiff>0) 
			{
				for(int i=0; i<yearDiff; i++)
				{
					 System.out.println("Year Diff->"+i);
					 Thread.sleep(5000);
					dobclicknext.click();
				}
			}
			
			//if you have to move previous year

            else if(yearDiff<0){

                for(int i=0;i< (yearDiff*(-1));i++){

                    System.out.println("Year Diff->"+i);
                    Thread.sleep(5000);

                    dobclickprev.click();

                }
		}
		
		*/
		Select selectGenderdd= new Select(selectGender);
		selectGenderdd.selectByVisibleText(gender);
		
		workPhone.sendKeys(workph);
		homePhone.sendKeys(homeph);
		workMobile.sendKeys(workMob);
		
		/*
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		*/
		
		//Select maritalStatusdd= new Select(SelectmaritalStatus);
		//maritalStatusdd.selectByValue(maritelstatus);
		
		SIN.sendKeys(sin);
		
		
		
	}
	
	

}
