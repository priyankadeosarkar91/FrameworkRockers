package com.Keyword;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	/**
	 * Opens Specified web Browser
	 * @param browserName- Browser Name should only include 
	 * Chrome, HTML, Firefox, IE & Safari no Beowsername apart from mentioned is allowed.
	 * 
	 */
	public static void openBrowser(String browserName) {
	switch (browserName) {
	case "Chrome":
		System.out.println("Opening Chrome Browser");
		WebDriverManager.chromedriver().setup();
		Constants.driver = new ChromeDriver();
		break;
	case "Firefox":
		System.out.println("Opening FirefoxDriver Browser");
		WebDriverManager.firefoxdriver().setup();
		Constants.driver = new FirefoxDriver();
		break;
	case "IE":
		System.out.println("Opening IE Browser");
		WebDriverManager.iedriver().setup();
		Constants.driver = new InternetExplorerDriver();
		break;
	case "Safari":
		break;
	default:
		System.out.println("Invalide browser name: " + browserName);
	}

			
	}
	/**
	 * It Opens the Specified url in web Browser recently opened by driver instance
	 * @param url {@code String} url to open
	 * @return void
	 */
		public static void openURL(String url) {
			System.out.println(url+" is loading");
			Constants.driver.get(url);
	}
		private static WebElement getWebElement(String locatorType, String locatorValue) {
			WebElement element=null;
		switch(locatorType) {
		case "XPATH":
			element=Constants.driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			element=Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			element=Constants.driver.findElement(By.id(locatorValue));
			break;
		case "LINKTEXT":
			element=Constants.driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element=Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "CLASS_NAME":
			element=Constants.driver.findElement(By.className(locatorValue));
			break;
		default:
			System.err.println("Invalid Lopcator Type" +locatorType +("Expected: CSS, XPATH, ID, LINKTEXT, PARTIAL_LINK_TEXT, CLASS_NAME"));
			break;
		}
		return element;

		}
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
			getWebElement(locatorType,locatorValue).sendKeys(textToEnter);
	}
	public static void clearText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType,locatorValue).clear();
}
		
	public static void clickonElement(String locatorType, String locatorValue) {
		getWebElement(locatorType,locatorValue).click();
	}
	public static void selectValueFromDropdown(String locaterType, String locatorValue, String textToSelect) {
		WebElement element=getWebElement(locaterType,locatorValue);
		Select select=new Select(element);
		select.selectByVisibleText(textToSelect);
	}
	public static void maximizeBrowser() {
		Constants.driver.manage().window().maximize();
	}
	public static void WindowHandlies(String webElement) {
		String parent_window=Constants.driver.getWindowHandle();
		System.out.println("Before Swiching Title is ="+Constants.driver.getTitle());
		Set<String> s1 =Constants.driver.getWindowHandles();
		Iterator<String> itr=s1.iterator();
		while(itr.hasNext()) {
			String childwindow=itr.next();
			if(parent_window.equals(childwindow)) {
				Constants.driver.switchTo().window(childwindow);
				System.out.println(Constants.driver.getTitle());
				Constants.driver.findElement(By.xpath(webElement)).click();
			}
		}
	}
	public static void JSE_ScrollBar() {
		JavascriptExecutor js=(JavascriptExecutor)Constants.driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	public static void addToCart(String element) {
		Constants.driver.findElement(By.xpath(element));
	}
	public static void actionOnElement(String action) {
		Actions action1=new Actions(Constants.driver);
		action1.moveToElement(Constants.driver.findElement(By.xpath(action))).click();
		action1.build().perform();
	}
	public static void deleteCookies() {
		Constants.driver.manage().deleteAllCookies();
	}
	public static void closeBrowser() {
		Constants.driver.close();
	}
	public static void closeAllBrowser() {
		Constants.driver.quit();
	}




}
