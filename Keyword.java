package com.Keyword;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Utilities.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	/**
	 * Opens Specified web Browser
	 * 
	 * @param browserName- Browser Name should only include Chrome, HTML, Firefox,
	 *                     IE & Safari no Beowsername apart from mentioned is
	 *                     allowed.
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

//----------------------------------------------------------------------------------------	
	
	/**
	 * It Opens the Specified url in web Browser recently opened by driver instance
	 * 
	 * @param url {@code String} url to open
	 * @return void
	 */
	public static void openURL(String url) {
		System.out.println(url + " is loading");
		Constants.driver.get(url);
	}

//----------------------------------------------------------------------------------------	
	
	//This is use for Locations
	private static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case "XPATH":
			element = Constants.driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			element = Constants.driver.findElement(By.id(locatorValue));
			break;
		case "LINKTEXT":
			element = Constants.driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element = Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "CLASS_NAME":
			element = Constants.driver.findElement(By.className(locatorValue));
			break;
		default:
			System.err.println("Invalid Lopcator Type" + locatorType
					+ ("Expected: CSS, XPATH, ID, LINKTEXT, PARTIAL_LINK_TEXT, CLASS_NAME"));
			break;
		}
		return element;

	}

//----------------------------------------------------------------------------------------
	
	// This is to use to Enter the text
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	
//----------------------------------------------------------------------------------------	
	
	// This is to use to clear the text
	public static void clearText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).clear();
	}

//----------------------------------------------------------------------------------------	
	
	// This is use to Clock on Element
	public static WebElement clickonElement(String locatorType, String locatorValue) {
		Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getWebElement(locatorType, locatorValue).click();
		return null;
	}

//----------------------------------------------------------------------------------------
	
	// This is use to select value from drop down
	public static void selectValueFromDropdown(String locaterType, String locatorValue, String textToSelect) {
		Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = getWebElement(locaterType, locatorValue);
		Select select = new Select(element);
		select.selectByVisibleText(textToSelect);
	}

//----------------------------------------------------------------------------------------	
	
	// This is Used to Maxmise the Browser
	public static void maximizeBrowser() {
		Constants.driver.manage().window().maximize();
	}

//----------------------------------------------------------------------------------------
	
	//This is use to Window Handling
	public static void WindowHandlies(String webElement) {
		String parent_window = Constants.driver.getWindowHandle();
		System.out.println("Before Swiching Title is =" + Constants.driver.getTitle());
		Set<String> s1 = Constants.driver.getWindowHandles();
		Iterator<String> itr = s1.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (parent_window.equals(childwindow)) {
				Constants.driver.switchTo().window(childwindow);
				System.out.println(Constants.driver.getTitle());
				Constants.driver.findElement(By.xpath(webElement)).click();
			}
		}
	}
	
//----------------------------------------------------------------------------------------
	
	//This is use to get title
	public static String getTitleofPage() {
		String title=Constants.driver.getTitle();
		return title;
	}
	
//----------------------------------------------------------------------------------------
	
	//This is use to perform Action
	public static void performAction(String locatortype, String locatorvalue) {
		Actions action = new Actions(Constants.driver);
		WebElement element1 = getWebElement(locatortype, locatorvalue);
		action.moveToElement(element1).perform();

	}
	
//----------------------------------------------------------------------------------------
	
	//This is use to read the code.jsonfile
	public static void readJsonfile() {
		JsonParser parser = new JsonParser();
		FileReader reader;
		try {
			reader = new FileReader("ExpectedHelptopics.json");
			Object obj = parser.parse(reader);
			JsonArray usersList = (JsonArray) obj;
			System.out.println(usersList);
			for (int i = 0; i < usersList.size(); i++) {
				JsonObject users = (JsonObject) usersList.get(i);
				System.out.println(users);
			}
		} catch (IOException  e) {
			e.printStackTrace();

		}
	}
	
//----------------------------------------------------------------------------------------	
	
	//To verifyText is present or not
		public static boolean verifyText(String value) {
			return Constants.driver.getPageSource().contains(value);
		}
		
//----------------------------------------------------------------------------------------
	
	//This is use to Up Scroll Bar 
	public static void UpScrollBar() {
		JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
		js.executeScript("window.scrollBy(0,200)","");
		js.executeAsyncScript("window.scrollBy(0,200)", "");
	}
	
	//This is use to down scroll Bar
	public static void downScrollBar() {
		JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
		js.executeScript("windowScrollBy(0,-200)", "");
	}
//-----------------------------------------------------------------------------------------
	
	// This is use to add product in cart
	public static void addToCart(String element) {
		Constants.driver.findElement(By.xpath(element));
	}
	
//-----------------------------------------------------------------------------------------	
	
	//This is use to apply sleep wait
	public static void applyWait() throws InterruptedException {
		Thread.sleep(3000);
	}
	
//-----------------------------------------------------------------------------------------	
	
	//This is use to take screen shot
	public static void takeScreenshot() throws IOException  {
		TakesScreenshot ts = (TakesScreenshot) Constants.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Scratch/Fullpagescreenshots.png"));
	}
	
//-----------------------------------------------------------------------------------------
	
	// Screenshot using Ashot
		public static void screenShotbymethod() {
			AShot ashot = new AShot();
			BufferedImage image = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
					.takeScreenshot(Constants.driver).getImage();
			try {
				ImageIO.write(image, "JPG", new File("D:\\Screenshot.UsingAshot.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//-----------------------------------------------------------------------------------------

	// This is use to action on element
	public static void actionOnElement(String action) {
		Actions action1 = new Actions(Constants.driver);
		action1.moveToElement(Constants.driver.findElement(By.xpath(action))).click();
		action1.build().perform();
	}
	
//-----------------------------------------------------------------------------------------	
	
	//Robot method 
		public static void usingAction() throws AWTException, IOException {
		Robot robo=new Robot();
		Rectangle rect=new Rectangle();
		rect.setBounds(0, 0, 1200, 1000);
		BufferedImage img=robo.createScreenCapture(rect);
		ImageIO.write(img, "PNG", new File("/Scratch/Screenshots.png"));
	}

//-----------------------------------------------------------------------------------------		
	
	//This is use to handle the Alert
	public static boolean ifAlert() {
		try {
			Constants.driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
//-----------------------------------------------------------------------------------------
	
	// This is use to apply wait
		public static void applyWaits() {
			Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		}
		
//-----------------------------------------------------------------------------------------	
	
	// This is use to delete the cookies
	public static void deleteCookies() {
		Constants.driver.manage().deleteAllCookies();
	}
	
//-----------------------------------------------------------------------------------------	
	
	//This is use to come on Home page
	public static void returnHomepage() {
		JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
		js.executeScript("window.history.go(-1)");
		System.out.println("Amazon Homepage");

	}

//-----------------------------------------------------------------------------------------	
	
	//This is use to close browser
	public static void closeBrowser() {
		Constants.driver.close();
	}

//-----------------------------------------------------------------------------------------	
		
	// This is use to close all browser
	public static void closeAllBrowser() {
		Constants.driver.quit();
	}

}
