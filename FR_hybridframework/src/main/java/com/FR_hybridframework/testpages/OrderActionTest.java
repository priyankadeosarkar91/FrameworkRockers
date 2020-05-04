package com.FR_hybridframework.testpages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.pages.CustomerservicePage;
import com.FR_hybridframework.pages.HomePage;
import com.FR_hybridframework.utilities.Custom_Listeners;


@Listeners(Custom_Listeners.class)
public class OrderActionTest extends SignIntest {

		@Test
		public void testorder() throws IOException, InterruptedException {
			log.info("************************Test Order in Amazon Pay*******************************");
			
			HomePage homepage = PageFactory.initElements(Constants.driver, HomePage.class);
			homepage.check_Dropdown("Home & Kitchen");
			homepage.tabTosearch("Water purifier");
			homepage.searchButton();
			Keyword.downScrollBar();
			Keyword.takeAScreenshot("testorder");
			Keyword.returnHomepage();
			CustomerservicePage service=PageFactory.initElements(Constants.driver,CustomerservicePage.class);
			service.selectService();
			Keyword.downScrollBar();
			service.findmoreSolutions("delivery");
			Keyword.clickOnElement("XPATH","//a[contains(text(),'Recommended Topics')]");
			
			//=============Please correct this=================
//			ReadJSON.readJSONfile();
//			Keyword.takeAScreenshot("testorder");
//			Keyword.applyWait();
//			Keyword.returnHomepage();
//			AmazonpayPage page=PageFactory.initElements(Constantss.driver, AmazonpayPage.class);
//			page.selectElement();

		}

}
