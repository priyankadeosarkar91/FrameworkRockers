package com.FR_hybridframework.testpages;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.utilities.Custom_Listeners;
import com.FR_hybridframework.utilities.Logged1;

@Listeners(Custom_Listeners.class)
public class Config_Test {
	
	static final Logger log = Logger.getLogger(Logged1.class);
	
	@BeforeSuite
	public void setup() {
		log.info("************************Opening browserName >>  Chrome*******************************");
		Keyword.openBrowser("Chrome");
		log.info("************************Opening URL*******************************");
		Keyword.openURL("https://www.amazon.in");
	}
	
	@AfterSuite
	public void teardown() {
//		Keyword.closeBrowser();
	}
	
}
