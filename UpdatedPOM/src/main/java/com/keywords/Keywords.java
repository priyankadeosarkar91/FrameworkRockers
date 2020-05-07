package com.keywords;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import com.keywords.Constantss;

public class Keywords {
	public static void openBrowser(String browserName) {

		switch (browserName) {
		case "Chrome":
			System.out.println("Opening Chrome Browser");
			WebDriverManager.chromedriver().setup();
			Constantss.driver = new ChromeDriver();
			break;
		case "Firefox":
			System.out.println("Openeing Firefox Driver");
			WebDriverManager.firefoxdriver().setup();
			Constantss.driver = new FirefoxDriver();
			break;
		case "IE":
			System.out.println("Opening Internet Explorer");
			WebDriverManager.iedriver().setup();
			Constantss.driver=new InternetExplorerDriver();
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
		// Const.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(url + "is Loading");
		Constantss.driver.get(url);
	}

//==============================================================///
	public static WebElement getWebElement(String locatortype, String locatorvalue) {
		WebElement element = null;
		switch (locatortype) {
		case "XPATH":
			element = Constantss.driver.findElement(By.xpath(locatorvalue));
			break;
		case "CSS":
			element = Constantss.driver.findElement(By.cssSelector(locatorvalue));
			break;
		case "ID":
			element = Constantss.driver.findElement(By.id(locatorvalue));
			break;
		case "LINKTEXT":
			element = Constantss.driver.findElement(By.linkText(locatorvalue));
			break;
		case "PARTIAL_LINKTEXT":
			element = Constantss.driver.findElement(By.partialLinkText(locatorvalue));
			break;
		case "CLASS_NAME":
			element = Constantss.driver.findElement(By.className(locatorvalue));
			break;
		case "NAME":
			element = Constantss.driver.findElement(By.name(locatorvalue));
		default:
			System.err.println("Invalid locator type " + locatortype
					+ ("Expected CSS,XPATH,PARTIAL_LINKTEXT,LINKTEXT,CLASS_NAME,ID"));
			break;
		}
		return element;
	}

//==============================================================//
	// This method entertext
	public static void enterText(String locatortype, String locatorvalue, String textToEnter) {
		Constantss.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getWebElement(locatortype, locatorvalue).sendKeys(textToEnter);
	}

//=============================================================//
	// click method to click particular element
	public static void clickonElement(String locatortype, String locatorvalue) {
		getWebElement(locatortype, locatorvalue).click();
	}

//=============================================================//
	// select from dropdown list
	public static void selectValueFromDropDown(String locatortype, String locatorvalue, String textToSelect) {
		Constantss.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = getWebElement(locatortype, locatorvalue);
		Select select = new Select(element);
		select.selectByVisibleText(textToSelect);
	}

//=============================================================//
	// scroll page up and down
	public static void upScrollBar() {
		JavascriptExecutor js = (JavascriptExecutor) Constantss.driver;
		js.executeScript("windowscrollBy(0,200)");
		js.executeAsyncScript("windowScrollBy(0,200)");
	}

	public static void downScrollBar() {
		JavascriptExecutor js = (JavascriptExecutor) Constantss.driver;
		js.executeScript("window.scrollBy(0,800)");
	}
	// ==========================================================//
	// window handling code

	public void switchToparentwindow() {
		String mainwindow = Constantss.driver.getWindowHandle();
		Set<String> set = Constantss.driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!mainwindow.equals(childwindow)) {
				Constantss.driver.switchTo().window(childwindow);
				System.out.println(Constantss.driver.switchTo().window(childwindow).getTitle());
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
		TakesScreenshot ts = (TakesScreenshot) Constantss.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:\\Users\\Hp\\eclipse-workspace\\POMFramework\\Screenshots\\UsingRobotClass.png"));

	}

	// ==============================================================//

	public static boolean ifAlert() {
		try {
			Constantss.driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// ===========================================================//
	// Screenshot using Ashot
	public static void screenShotbymethod() {
		AShot ashot = new AShot();
		BufferedImage image = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
				.takeScreenshot(Constantss.driver).getImage();
		try {
			ImageIO.write(image, "JPG",
					new File("C:\\Users\\Hp\\eclipse-workspace\\POMFramework\\fullscreenshot\\.UsingAshot.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// =====================================================//
	// wait
	public static void applyWaits() {
		Constantss.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

	// ====================================================================//
	public static void performAction(String locatortype, String locatorvalue) {
		Actions action = new Actions(Constantss.driver);
		WebElement element1 = getWebElement(locatortype, locatorvalue);
		action.moveToElement(element1).perform();

	}

	// =================================================================//
	// Robot method
	public void usingAction() throws AWTException, IOException {
		Robot robo = new Robot();
		Rectangle rect = new Rectangle();
		rect.setBounds(0, 0, 1200, 1000);
		BufferedImage img = robo.createScreenCapture(rect);
		ImageIO.write(img, "PNG", new File("D:\\Screenshots.UsingRobotclass.png"));
	}

// =============================================================//
	// to maximize browser
	public static void maximizeBrowser() {
		Constantss.driver.manage().window().maximize();
	}

//===========================================================//
	public static void returnHomepage() {
		JavascriptExecutor js = (JavascriptExecutor) Constantss.driver;
		js.executeScript("window.history.go(-1)");
		System.out.println("Amazon Homepage");

	}// =============================================================//

	public static WebDriver getDriver() {
		if (Constantss.driver == null) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			WebDriverManager.chromedriver().setup();
			Constantss.driver = new ChromeDriver(options);
			Constantss.driver.manage().window().maximize();
			Constantss.driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			Constantss.driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		}
		return Constantss.driver;

	}

	// ==============================================================//
	// code to read.jsonfile
	public static void readJsonfile() {
		JSONParser parser = new JSONParser();
		FileReader reader;
		try {
			reader = new FileReader("C:\\Users\\Hp\\eclipse-workspace\\POMFramework\\src\\main\\resources\\ExpectedHelpTopics.json");
			Object obj = parser.parse(reader);
			JSONArray usersList = (JSONArray) obj;
			System.out.println(usersList);
			for (int i = 0; i < usersList.size(); i++) {
				JSONObject users = (JSONObject) usersList.get(i);
				System.out.println(users);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	// ====================================================================//
//To verifyText is present or not

	public static boolean verifyText(String value) {
		return Constantss.driver.getPageSource().contains(value);
	}
	//=========================================================//
	public void mousehoverOnSignInTab() {
		Constantss.action = new Actions(Constantss.driver);
		WebElement signintab_Mhover = null;
		Constantss.action.moveToElement(signintab_Mhover).perform();
	}

	public void clickonSignInTab() {
		Constantss.action = new Actions(Constantss.driver);
		WebElement signintab_Mhover = null;
		Constantss.action.moveToElement(signintab_Mhover).click().perform();
	}
	public void selectProductFromListByIndex() {
		Constantss.parentWindowHandle=Constantss.driver.getWindowHandle();
		WebElement productselect=null;
		productselect.click();
		Set <String> childWindow=Constantss.driver.getWindowHandles();
		System.out.println("child Window handles : " + childWindow);
		
		for(String handle:childWindow) {
			if(!Constantss.parentWindowHandle.equalsIgnoreCase(handle)) {
				Constantss.driver.switchTo().window(handle);
			}
		}
	}

	
	

//====================================================================//
	// To close open browser
	public static void closeBrowser() {
		Constantss.driver.close();
	}

//=============================================================//
	public static void closeAllbrowser() {
		Constantss.driver.quit();
	}
}
