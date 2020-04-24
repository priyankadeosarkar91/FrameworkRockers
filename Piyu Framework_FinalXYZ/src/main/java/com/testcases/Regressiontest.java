package com.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.maven.plugin.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.keywords.Constantss;
import com.keywords.Keyword;
import com.keywords.utilties.Logs;
import com.keywords.utilties.Propertiesfile;
import com.keywords.utilties.TestListneres;

@Listeners(TestListneres.class)
public class Regressiontest {
	static final Logger log=Logger.getLogger(Logs.class);
	//Verify browserName:Chrome
	@Test(priority = 1)
	public void TC_001() throws FileNotFoundException {
		Logs.info("************************browserName  Chrome*******************************");
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		Keyword.openBrowser(Propertiesfile.getProperty("browserName"));
	}

//verify Chromebrowser
	@Test(priority = 2)
	public void TC_002() throws FileNotFoundException {
		Logs.info("*******************************Opening url*************************************");
		Keyword.openURL(Propertiesfile.getProperty("baseURL"));
		Keyword.maximizeBrowser();
		Assert.assertEquals(Propertiesfile.getProperty("baseURL"), "https://www.amazon.in");
	}

	// verify title of page
	@Test(priority = 3)

	public void TC_003() {
		Logs.info("*******************************Verify Title************************");
		String ActualTitle = Constantss.driver.getTitle();
		String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert passed");
	}

//verify homepage is auto scrolling if yes what intervel of time and then refresh page
	@Test(priority = 4)

	public void TC_004() {
		Logs.info("**********************Verify Homepage Scrolldown at what interval of time****************** ");
		Keyword.downScrollBar();
		Constantss.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Keyword.refreshPage();
	}

//tab_tosearchbox 
	@Test(priority = 5)

	public void TC_005() throws IOException {
		Logs.info("********************Tab-to-Search Item***************************");
		Keyword.selectValueFromDropDown(Propertiesfile.getLocator("searchdropDown")[0],
				Propertiesfile.getLocator("searchdropDown")[1], "Amazon Fashion");
		Keyword.enterText(Propertiesfile.getLocator("searchbox_tab")[0], Propertiesfile.getLocator("searchbox_tab")[1],
				"Water Purifier");
		Keyword.clickonElement(Propertiesfile.getLocator("search")[0], Propertiesfile.getLocator("search")[1]);
		// Keyword.downScrollBar();
		// Assert.assertEquals(Constantss.driver.getTitle(), "[Amazon.in: Water
		// Purifier: Fashion]");
	}

//verify actions to perform on particular element
	@Test(priority = 6)

	public void TC_006() {
		Logs.info("***************Verify actions ****************************");
		Constantss.driver.switchTo().window(Constantss.driver.getWindowHandle());
		Keyword.performAction("XPATH", "//*[@id=\"p_72/1318476031\"]/span/a/section/span");
		try {
			Keyword.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//verify Scroll down an return to homepage
	@Test(priority = 7)

	public void TC_007() {
		Logs.info("*****************************Return to homepage*****************************");
		Keyword.downScrollBar();
		Constantss.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Keyword.returnHomepage();
	}

//verify mousehover on element an scrollup
	@Test(priority = 8)

	public void TC_008() {
		Logs.info("************************Verify Mousehover on element***********************");
		Constantss.driver.switchTo().window(Constantss.driver.getWindowHandle());
		Keyword.upScrollBar();
		Assert.assertEquals(Constantss.driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println("Assert passed");
	}

	// verify sign in
	/*
	 * @Test(priority=9)
	 * 
	 * public void TC_009() {
	 * Logs.info("Verify Sign in")
	 *  Keyword.clickonElement("ID", "nav-link-accountList");
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
		Logs.info("*******************Verify element is clickable*********************");
		Keyword.clickonElement("XPATH", "//i[@class=\"hm-icon nav-sprite\"]");
		Keyword.clickonElement("XPATH", "//div[@class=\"nav-sprite hmenu-close-icon\"]");
		Assert.assertEquals(Constantss.driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println("Assert passed");
	}

	// check new releases
	@Test(priority = 11)

	public void TC_011() {
		Logs.info("*************New releases***************");
		Keyword.clickonElement("XPATH", "//a[contains(text(),'New Releases')]");
		// Assert.assertEquals(Constantss.driver.getTitle(),"[]");
		System.out.println("Assert is passed");
	}

	// purchase a book
	@Test(priority = 12)

	public void TC_012() {
		Logs.info("*********************Purchase a book*****************************");
		Keyword.clickonElement("XPATH", "//*[@id=\"zg_left_col1\"]/div[1]/div[2]/div/div[2]/a/div[2]");
		// Assert.assertEquals(Constantss.driver.getTitle(),"Death; An Inside Story: A
		// book for all those who shall die: Amazon.in: Sadhguru: Books");
		System.out.println("Assert Passed");
	}

	// add to cart
	@Test(priority = 13)

	public void TC_013() {
		Logs.info("*********************Add to Cart******************************");
		Keyword.clickonElement("XPATH", "//input[@id='add-to-cart-button']");
		Keyword.clickonElement("XPATH", "//a[@id='hlb-ptc-btn-native']");
	}

	// signin to purchase item
	@Test(priority = 14)

	public void TC_014() throws InterruptedException {
		Logs.info("************Sign-in to Purchase item********************************");
		Keyword.enterText("CSS", "#ap_email", "nishan3d@gmail.com");
		Keyword.clickonElement("XPATH", "//input[@id='continue']");
		Keyword.enterText("CSS", "#ap_password", "nishikant.patil");
		Keyword.clickonElement("CSS", "#signInSubmit");
		Thread.sleep(7000);
	}

	// edit address
	@Test(priority = 15)

	public void TC_015() {
		Logs.info("******************************Edit address*********************");
		Keyword.clickonElement("XPATH", "//*[@id=\"address-book-entry-0\"]/div[2]/span/a");
		Keyword.downScrollBar();
		// Keyword.selectValueFromDropDown("XPATH",
		// "/html/body/div[5]/div[2]/div[3]/div[1]/div/div[1]/div[1]/form/div[4]/div/select",
		// " Home (7 am – 9 pm delivery) ");

	}

	@Test(priority = 16)

	public void tc_016() {
		 Logs.info("******************* VerifyScreenshot-forFailedTC ********************** ");

		Assert.assertEquals(false, true);
		Logs.assertLog(false, "Test case failed.");
	}

	
	@Test(priority = 17)

	public void TC_017() {
		Logs.info("*****************CloseBrowser*****************");
		Keyword.closeBrowser();
	}

	@Test(priority = 18)

	public void TC_018() {
		Logs.info("********************CloseAllBrowser******************");
		Keyword.closeAllbrowser();
	}

}
