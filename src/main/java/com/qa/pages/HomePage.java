package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import net.bytebuddy.asm.Advice.This;

public class HomePage extends TestBase {
	
	
	
	@FindBy (xpath="//div[contains(text(),'My Records')]")
	WebElement EmpRecordsLink;
	
	//Initializing the Page Objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String VerifyHomeTitle()
	{
		return driver.getTitle();
	}

	public SubHomePage clickOnEmpRecords()
	{
		EmpRecordsLink.click();
		return new SubHomePage();
	}
}
