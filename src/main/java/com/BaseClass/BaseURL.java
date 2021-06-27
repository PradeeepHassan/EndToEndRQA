package com.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseURL {
	
	
	
	public WebDriver driver;
	public Properties prop;
	
	public static Logger log =LogManager.getLogger(BaseURL.class.getName());
	@BeforeMethod
	public WebDriver intilizedriver() throws IOException {
		
		
		 prop=new Properties();
//		FileInputStream fis=new FileInputStream("F:\\Udemy Maven\\EndToEnd\\src\\main\\java\\resources\\data.propertise");
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\\\src\\\\main\\\\java\\\\resources\\\\data.propertise");
		prop.load(fis);
		
		String browserName=System.getProperty("broswer");
//		String browserName=prop.getProperty("broswer");
		
		if(browserName.equals("chrome")) {
			
//			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver", "F:\\Udemy Maven\\EndToEnd\\src\\main\\java\\resources\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
//			driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/#");
			driver.navigate().to(prop.getProperty("URL"));
//			log.info(" browser lanched sucessfully");
//			
		}
		
		else if(browserName.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
//			driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/#");
			driver.navigate().to(prop.getProperty("URL"));
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

	@AfterMethod
	
	public void afterMehode() {
		
		driver.quit();
		
		
		
	}
	
	public void getScreenShot(String testCaseName, WebDriver driver) throws IOException  {
		
		
	TakesScreenshot	ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destination));
	}
}

