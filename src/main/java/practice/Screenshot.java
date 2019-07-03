package practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class Screenshot 
{
		
	static WebDriver driver ;
		
		public static void main(String[] args) throws IOException
		
		{
			
		
		System.setProperty("webdriver.chrome.driver", "D:/Shweta/Selenium/Drivers/chromedriver.exe");
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("http://sbvt-web-01:16");
		
	
			driver.findElement(By.xpath("//input[@id='inputUserName']")).sendKeys("972718");
		
			driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("Welcome123");
		
			driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
			driver.manage().timeouts().implicitlyWait(350,TimeUnit.SECONDS);
			
			takeScreenshot("hcmlogin");
		}
		
		
			public static void takeScreenshot(String filename) throws IOException
			{
			
				String dateName= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				//TakesScreenshot ts= (TakesScreenshot) driver;
				
			//	File source =ts.getScreenshotAs(OutputType.FILE);
				//String currentDir = System.getProperty("user.dir");
				//FileUtils.copyFile(source, new File(currentDir + "/New/" + dateName +".png")); 
		//		FileUtils.copyFile(file, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
			//	System.out.println("End...");
				
				//return destination;
				
				
				
				File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				//2. copy screenshot to desired location using copy file method
				String currentDir = System.getProperty("user.dir");
				FileUtils.copyFile(file, new File("D:/Shweta/Selenium" + "/Screenshots1/" + System.currentTimeMillis() + ".png"));
				
			}
			
		
		
		}
		
	



