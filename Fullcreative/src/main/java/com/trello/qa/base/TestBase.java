package com.trello.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.trello.qa.utility.PropertiesUtils;

public class TestBase {
	public static WebDriver driver =null;
	public static Logger log = Logger.getLogger("Base");
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	public static long PAGE_LOAD_TIMEOUT = 20;
	
public static void initialization() {
	String browser=PropertiesUtils.readProperty("browser");
	log.info("initializing browser");
	if(browser.equals("chrome")) {
      System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\Chromedriver.exe");
      driver= new ChromeDriver();
	}
	   if(browser.equals("firefox")){
       System.setProperty("webdriver.gecko.driver","D:\\Geckodriver");
       driver= new FirefoxDriver();
	}
	
	   driver.manage().window().maximize();
	   driver.get(PropertiesUtils.readProperty("url"));
	   driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
	   
	 
}
 public static void reportInit() {
	 report =new ExtentReports();
	 spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html"	);
	 report.attachReporter(spark);
		 
 }
 
 public String takeScreenShot(String name) {
	 TakesScreenshot screenshot = (TakesScreenshot) driver;
	 File source =screenshot.getScreenshotAs(OutputType.FILE);
	 String path = System.getProperty("user.dir"+"\\screenshot\\"+ name+".jpg");
	 File destination = new File(path);
	 try {
		FileUtils.copyFile(source, destination);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return path;
		 
 }
 

}
