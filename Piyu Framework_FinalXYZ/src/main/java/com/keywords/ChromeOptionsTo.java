package com.keywords;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsTo {
	public static void addInChrome() {
		
	Constantss.options = new ChromeOptions();
	//Constants.options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	Constantss.options.addArguments("--start-maximized");
	Constantss.options.addArguments("--disable-notifications");
	Constantss.options.addArguments("disable-infobars");
	
	}

}
