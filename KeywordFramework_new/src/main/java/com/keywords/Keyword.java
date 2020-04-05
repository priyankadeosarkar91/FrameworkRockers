package com.keywords;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			System.out.println("Opening Chrome Browser");
			WebDriverManager.chromedriver().setup();
			Constant.driver = new ChromeDriver();
			break;
		case "Firefox":
			System.out.println("Openeing Firefox Driver");
			WebDriverManager.firefoxdriver().setup();
			Constant.driver = new FirefoxDriver();
			break;
		case "IE":
			System.out.println("Opening Internet Explorer");
			WebDriverManager.iedriver().setup();
		case "Safari":
		default:
			System.out.println("Invalid BrowserName " + browserName);
			break;
		}
	}

//============================================================//
	/**
	 * It open specified Url in WebBrowser recently opened by driver instance
	 * {@code String} Url to open
	 * 
	 * @return void
	 */
	public static void openURL(String url) {
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(url + "is Loading");
		Constant.driver.get(url);
	}

//==============================================================///
	private static WebElement getWebElement(String locatortype, String locatorvalue) {
		WebElement element = null;
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		switch (locatortype) {
		case "XPATH":
			element = Constant.driver.findElement(By.xpath(locatorvalue));
			break;
		case "CSS":
			element = Constant.driver.findElement(By.cssSelector(locatorvalue));
			break;
		case "ID":
			element = Constant.driver.findElement(By.id(locatorvalue));
			break;
		case "LINKTEXT":
			element = Constant.driver.findElement(By.linkText(locatorvalue));
			break;
		case "PARTIAL_LINKTEXT":
			element = Constant.driver.findElement(By.partialLinkText(locatorvalue));
			break;
		case "CLASS_NAME":
			element = Constant.driver.findElement(By.className(locatorvalue));
			break;
		case "NAME":
			element = Constant.driver.findElement(By.name(locatorvalue));
		default:
			System.err.println("Invalid locator type " + locatortype
					+ ("Expected CSS,XPATH,PARTIAL_LINKTEXT,LINKTEXT,CLASS_NAME,ID"));
			break;
		}
		return element;
	}

//==============================================================//
	public static void enterText(String locatortype, String locatorvalue, String textToEnter) {
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getWebElement(locatortype, locatorvalue).sendKeys(textToEnter);
	}

//=============================================================//
	public static void clickonElement(String locatortype, String locatorvalue) {
		getWebElement(locatortype, locatorvalue).click();
	}

//=============================================================//
	public static void selectValueFromDropDown(String locatortype, String locatorvalue, String textToSelect) {
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = getWebElement(locatortype, locatorvalue);
		Select select = new Select(element);
		select.selectByVisibleText(textToSelect);
	}

//=============================================================//
	// scroll page up and down
	public static void upScrollBar() {
		JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
		js.executeScript("windowScrollBy(0,200)", "");
	}

	public static void downScrollBar() {
		JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
		js.executeScript("windowScrollBy(0,200)", "");
	}

//=============================================================//
	public static void switchONnewwindow(String webElement) {
		String parent_window = Constant.driver.getWindowHandle();
		System.out.println("before switch title is " + Constant.driver.getTitle());
		Set<String> s = Constant.driver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (parent_window.equals(childwindow)) {
				Constant.driver.switchTo().window(childwindow);
				System.out.println(Constant.driver.getTitle());
				Constant.driver.findElement(By.xpath(webElement)).click();
			}
		}
	}

//============================================================//
	public static void applyWait() throws InterruptedException {
		Thread.sleep(3000);
	}
//===================================================//
	// Takes screenshot

	public static void takeScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) Constant.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Screenshot.UsingRobotclass.png"));

	}

	// ==============================================================//
	public static boolean ifAlert() {
		try {
			Constant.driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// ===========================================================//
	public static void screenShotbymethod() {
		AShot ashot = new AShot();
		BufferedImage image = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
				.takeScreenshot(Constant.driver).getImage();
		try {
			ImageIO.write(image, "JPG", new File("D:\\Screenshot.UsingAshot.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Constant.driver.quit();
		}
	}

	// =====================================================//
	// wait
	public static void applyWaits() {
		Constant.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	// =============================================================//
	// to maximize browser
	public static void maximizeBrowser() {
		Constant.driver.manage().window().maximize();
	}

//===========================================================//
	// To close open browser
	public static void closeBrowser() {
		Constant.driver.close();
	}

//=============================================================//
	// to close all opened browsers
	public static void closeAllbrowser() {
		Constant.driver.quit();
	}
}
