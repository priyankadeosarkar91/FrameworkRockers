package com.testingshastra.test;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.keyword.BrowserInstance;
import com.testingshastra.keyword.BrowserSetUp;
import com.testingshastra.utilities.Utilis;

public class HomePageSmokeTest {
	@Test
	public static void VerifyMenuItems() throws FileNotFoundException {
		String[] expectedSubNamItems= {"HOME","COURSES","DOWNLOAD","VIDEO","ASSIGNMENS","ABOUT","CONTACT US"};
		BrowserSetUp.openBrowser("IE");
		BrowserSetUp.openURL("http://www.testingshastra.com");
		List<WebElement> subNamItems=(List<WebElement>) BrowserInstance.driver.findElement(By.cssSelector(Utilis.getProperty("home.sunNavItem")));
		
		ArrayList<String> actualSubNamItems=new ArrayList<String>();
		
		Iterator<WebElement> itr=subNamItems.iterator();
		while(itr.hasNext()) {
			actualSubNamItems.add(itr.next().getText());
		}	
		boolean isEqual=actualSubNamItems.containsAll(Arrays.asList(expectedSubNamItems));
		Assert.assertTrue(isEqual);
	}

	
}
