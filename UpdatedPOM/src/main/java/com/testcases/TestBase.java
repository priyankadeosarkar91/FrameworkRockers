package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.keywords.Constantss;
import com.keywords.Keywords;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	@BeforeSuite
	public void initialize() {
		Keywords.openBrowser("Chrome");
		Constantss.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Keywords.openURL("https://www.amazon.in");
		Keywords.maximizeBrowser();

	}
	
//	@AfterSuite
	//public void tearDowntest() {
		//TestBase.driver.quit();
		
	//}

}



