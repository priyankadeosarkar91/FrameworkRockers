package com.framework_PDD.amazon.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.framework_PDD.keywords.Keyword;

public class Config_Test {

	@BeforeSuite
	public void setup() {
		Keyword.openBrowser("Chrome");
		Keyword.openURL("https://www.amazon.in");
	}
	
	@AfterSuite
	public void teardown() {
		Keyword.closeBrowser();
	}
}
