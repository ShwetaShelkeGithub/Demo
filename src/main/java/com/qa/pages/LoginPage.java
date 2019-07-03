package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory
	@FindBy(name="UserName")
	WebElement username;
	
	@FindBy(name="UserPassword")
	WebElement userpassword;
	

	@FindBy(xpath="//button[@id='btnLogin'] ")
	WebElement loginbutton;
	
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String loginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		userpassword.sendKeys(pwd);
		Thread.sleep(2000);
		loginbutton.click();
		Thread.sleep(5000);
		return new HomePage(); // return HomePage() class object
	}
	
}
