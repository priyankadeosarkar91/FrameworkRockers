package com.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazonpages.AmazonpayPage;
import com.amazonpages.Customerservicepage;
import com.amazonpages.HomePage;
import com.amazonpages.SignInPage;
import com.amazonpages.SigninPages;
import com.aventstack.extentreports.ExtentTest;
import com.keyword.utilities.Logs;
import com.keywords.Constantss;
import com.keywords.Keyword;
import com.keywords.Keywords;
import com.keyword.utilities.TestListneres;

@Listeners(TestListneres.class)
public class Orderactions extends TestBase {

	static final Logger log = Logger.getLogger(Logs.class);
	// Verify browserName:Chrome

	@Test
	public void testorder() throws IOException, InterruptedException {
		log.info("*****************************SignIn ********************************");
		SignInPage signin = PageFactory.initElements(
				Constantss.driver.switchTo().window(Constantss.driver.getWindowHandle()), SignInPage.class);
		signin.mousehoverOnSignInTab();
		signin.clickonSignInTab();
		Constantss.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		signin.emailorPhone("nishan3d@gmail.com");
		signin.continueSignin();
		signin.password("nishikant.patil"); //
		Constantss.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		signin.login();
		Thread.sleep(50000);
		log.info("**********************SignIn Successful*******************");
	}

	@Test
	public void testHomepage() {
		log.info("******************HomePage Verification*******************************");
		HomePage homepage = PageFactory.initElements(Constantss.driver, HomePage.class);
		homepage.check_Dropdown("Home & Kitchen");
		Constantss.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		homepage.tabTosearch("Water purifier");
		homepage.searchButton();
		Keywords.downScrollBar();
		try {
			Keywords.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Constantss.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Keywords.returnHomepage();
		log.info("***********************Return to Homepage*********************");
	}

	@Test
	public void checkCustomerServicedetails() throws IOException {
		log.info("******************Check Customer ServiceDetails********************");
		Customerservicepage service = PageFactory.initElements(Constantss.driver, Customerservicepage.class);
		service.selectService();
		Constantss.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Keywords.downScrollBar();
		service.findmoreSolutions("delivery");
		Keywords.performAction("XPATH", "//a[contains(text(),'Recommended Topics')]");
		// Keywords.readJsonfile();
		Keywords.takeScreenshot();
		Constantss.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Keywords.returnHomepage();
	}

	@Test
	public void payAmazon() {
		log.info("*********************Amazon Pay Details************************");
		AmazonpayPage page = PageFactory.initElements(Constantss.driver, AmazonpayPage.class);
		page.selectElement();
		page.selectBirthdaycard();
		Constantss.driver.switchTo().window(Constantss.driver.getWindowHandle());
		page.hoverMouse();
		// Keywords.downScrollBar();
		log.info("*******************Birthday Card successfully selected**************************");
	}
}