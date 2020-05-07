package com.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.keywords.Constantss;
import com.keywords.Keywords;

public class Tests extends ExtentReportDemo{
	static final ExtentReportDemo d =new ExtentReportDemo();
	static final ExtentReports extent = new ExtentReports();
	static final ExtentTest logger=extent.createTest("LoginTest");
	@Test
	public void TC_01() {
   logger.log(Status.INFO,"Login to amazon");
   System.out.println("Sign in to my account");
   Keywords.openBrowser("Chrome");
	Constantss.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Keywords.openURL("https://www.amazon.in");
	Keywords.maximizeBrowser();
	System.out.println("Url is opened ");

	
	}
}
