package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("D:/Shweta/Selenium/Workspace/HCMNew/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Shweta/Selenium/Drivers/chromedriver.exe");	
			driver=new ChromeDriver();
		}
	
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Shweta/Selenium/Drivers/chromedriver.exe");	
			driver=new FirefoxDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	}
	
	public static void implictWait()
	{
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	/*
	 * public static void explicitWait() { WebDriverWait wait=new
	 * WebDriverWait(driver, TestUtil.Expllicite_Wait); WebElement clicklink =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) }
	 */
	
}
