package com.testingshastra.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetUp {
		public static void openBrowser(String browserName) {
			switch (browserName) {
			case "Chrome":
				System.out.println("Opening Chrome Browser");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRASHANT\\Desktop\\JAVA\\SP\\JARFiles\\chromedriver.exe");
				BrowserInstance.driver = new ChromeDriver();
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				BrowserInstance.driver = new FirefoxDriver();
				break;
			case "IE":
				WebDriverManager.iedriver().setup();
				BrowserInstance.driver = new InternetExplorerDriver();
				break;
			case "Safari":
				break;
			default:
				System.out.println("Invalide browser name: " + browserName);
			}

		}

		public static void openURL(String url) {
			System.out.println(url + " is loading");
			BrowserInstance.driver.get(url);
		}
		private static WebElement getWebElement(String locatorType, String locatorValue) {
			WebElement element = null;
			switch (locatorType) {
			case "XPATH":
				element = BrowserInstance.driver.findElement(By.xpath(locatorValue));
				break;
			case "CSS":
				element = BrowserInstance.driver.findElement(By.cssSelector(locatorValue));
				break;
			case "ID":
				element = BrowserInstance.driver.findElement(By.id(locatorValue));
				break;
			case "LINKTEXT":
				element = BrowserInstance.driver.findElement(By.linkText(locatorValue));
				break;
			case "PARTIAL_LINK_TEXT":
				element = BrowserInstance.driver.findElement(By.partialLinkText(locatorValue));
				break;
			case "CLASS_NAME":
				element = BrowserInstance.driver.findElement(By.className(locatorValue));
				break;
			default:
				System.err.println("Invalid Lopcator Type" + locatorType
						+ ("Expected: CSS, XPATH, ID, LINKTEXT, PARTIAL_LINK_TEXT, CLASS_NAME"));
				break;
			}
			return element;

		}

		public static void enterText(String locatorType, String locatorValue, String textToEnter) {
			getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
		}

		public static void clickonElement(String locatorType, String locatorValue) {
			getWebElement(locatorType, locatorValue).click();
		}
		public static void maximizeBrowser() {
			BrowserInstance.driver.manage().window().maximize();
		}

}

	
