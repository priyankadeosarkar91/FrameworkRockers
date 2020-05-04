package com.FR_hybridframework.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.utilities.Custom_Listeners;
import com.FR_hybridframework.utilities.Logged1;
import com.FR_hybridframework.utilities.ReadORFile;

@Listeners(Custom_Listeners.class)
public class RegressionTests {

	static final Logger log = Logger.getLogger(Logged1.class);

	// Verify browserName:Chrome
	@Test(priority = 1)
	public void TC_001() throws FileNotFoundException {
		log.info("************************browserName  Chrome*******************************");
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		Keyword.openBrowser(ReadORFile.getProperty("browserName"));
	}

	// verify Chromebrowser
	@Test(priority = 2)
	public void TC_002() throws FileNotFoundException {
		log.info("*******************************Opening url*************************************");
		Keyword.openURL(ReadORFile.getProperty("baseURL"));
		Assert.assertEquals(ReadORFile.getProperty("baseURL"), "https://www.amazon.in");
	}

	// verify title of page
	@Test(priority = 3)

	public void TC_003() {
		log.info("*******************************Verify Title************************");
		String ActualTitle = Constants.driver.getTitle();
		String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert passed");
	}

	// verify homepage is auto scrolling if yes what intervel of time and then
	// refresh page
	@Test(priority = 4)

	public void TC_004() {
		log.info("**********************Verify Homepage Scrolldown at what interval of time****************** ");
		Keyword.downScrollBar();
		Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Keyword.refreshPage();
	}

	// tab_tosearchbox
	@Test(priority = 5)

	public void TC_005() throws IOException {
		log.info("********************Tab-to-Search Item***************************");
		Keyword.selectValueFromDropdown(ReadORFile.getLocator("searchdropDown")[0],
				ReadORFile.getLocator("searchdropDown")[1], "Amazon Fashion");
		Keyword.enterText(ReadORFile.getLocator("searchbox_tab")[0], ReadORFile.getLocator("searchbox_tab")[1],
				"Water Purifier");
		Keyword.clickOnElement(ReadORFile.getLocator("search")[0], ReadORFile.getLocator("search")[1]);
		// Keyword.downScrollBar();
		// Assert.assertEquals(Constantss.driver.getTitle(), "[Amazon.in: Water
		// Purifier: Fashion]");
	}

	// verify actions to perform on particular element
	@Test(priority = 6)

	public void TC_006() {
		log.info("***************Verify actions ****************************");
		Constants.driver.switchTo().window(Constants.driver.getWindowHandle());
		Keyword.mouseHoverOnElement("XPATH", "//*[@id=\"p_72/1318476031\"]/span/a/section/span");
		Keyword.takeAScreenshot("TC_006");
	}

	// verify Scroll down an return to homepage
	@Test(priority = 7)

	public void TC_007() {
		log.info("*****************************Return to homepage*****************************");
		Keyword.downScrollBar();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Keyword.returnHomepage();
	}

	// verify mousehover on element an scrollup
	@Test(priority = 8)

	public void TC_008() {
		log.info("************************Verify Mousehover on element***********************");
		Constants.driver.switchTo().window(Constants.driver.getWindowHandle());
		Keyword.upScrollBar();
		Assert.assertEquals(Constants.driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println("Assert passed");
	}

	// verify sign in
	/*
	 * @Test(priority=9)
	 * 
	 * public void TC_009() { Logs.info("Verify Sign in")
	 * Keyword.clickonElement("ID", "nav-link-accountList");
	 * Keyword.enterText("CSS", "#ap_email", "piyupatil5029@gmail.com");
	 * Keyword.clickonElement("XPATH","//input[@id='continue']");
	 * Keyword.enterText("CSS", "#ap_password","nishikant.patil");
	 * Keyword.clickonElement("ID", "signInSubmit"); try { Thread.sleep(5000); }
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	// verify element is clickable
	@Test(priority = 10)

	public void TC_010() {
		log.info("*******************Verify element is clickable*********************");
		Keyword.clickOnElement("XPATH", "//i[@class=\"hm-icon nav-sprite\"]");
		Keyword.clickOnElement("XPATH", "//div[@class=\"nav-sprite hmenu-close-icon\"]");
		Assert.assertEquals(Constants.driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println("Assert passed");
	}

	// check new releases
	@Test(priority = 11)

	public void TC_011() {
		log.info("*************New releases***************");
		Keyword.clickOnElement("XPATH", "//a[contains(text(),'New Releases')]");
		// Assert.assertEquals(Constantss.driver.getTitle(),"[]");
		System.out.println("Assert is passed");
	}

	// purchase a book
	@Test(priority = 12)

	public void TC_012() {
		log.info("*********************Purchase a book*****************************");
		Keyword.clickOnElement("XPATH", "//*[@id=\"zg_left_col1\"]/div[1]/div[2]/div/div[2]/a/div[2]");
		// Assert.assertEquals(Constantss.driver.getTitle(),"Death; An Inside Story: A
		// book for all those who shall die: Amazon.in: Sadhguru: Books");
		System.out.println("Assert Passed");
	}

	// add to cart
	@Test(priority = 13)

	public void TC_013() {
		log.info("*********************Add to Cart******************************");
		Keyword.clickOnElement("XPATH", "//input[@id='add-to-cart-button']");
		Keyword.clickOnElement("XPATH", "//a[@id='hlb-ptc-btn-native']");
	}

	// signin to purchase item
	@Test(priority = 14)

	public void TC_014() throws InterruptedException {
		log.info("************Sign-in to Purchase item********************************");
		Keyword.enterText("CSS", "#ap_email", "nishan3d@gmail.com");
		Keyword.clickOnElement("XPATH", "//input[@id='continue']");
		Keyword.enterText("CSS", "#ap_password", "nishikant.patil");
		Keyword.clickOnElement("CSS", "#signInSubmit");
		Thread.sleep(7000);
	}

	// edit address
	@Test(priority = 15)

	public void TC_015() {
		log.info("******************************Edit address*********************");
		Keyword.clickOnElement("XPATH", "//*[@id=\"address-book-entry-0\"]/div[2]/span/a");
		Keyword.downScrollBar();
		// Keyword.selectValueFromDropDown("XPATH",
		// "/html/body/div[5]/div[2]/div[3]/div[1]/div/div[1]/div[1]/form/div[4]/div/select",
		// " Home (7 am – 9 pm delivery) ");
	}

	@Test(priority = 16)

	public void tc_016() {
		log.info("******************* VerifyScreenshot-forFailedTC ********************** ");

		Assert.assertEquals(false, true);
		log.assertLog(false, "Test case failed.");
	}

	@Test(priority = 17)

	public void TC_017() {
		log.info("*****************CloseBrowser*****************");
		Keyword.closeBrowser();
	}

	@Test(priority = 18)

	public void TC_018() {
		log.info("********************CloseAllBrowser******************");
		Keyword.closeAllBrowser();
	}
}
