package com.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazonpages.AmazonpayPage;
import com.amazonpages.Customerservicepage;
import com.amazonpages.HomePage;
import com.amazonpages.SignInPage;
import com.keywords.Constantss;
import com.keywords.Keywords;

public class Orderactions {
	@Test
	public void testorder() throws IOException, InterruptedException {
		Keywords.openBrowser("Chrome");
		Keywords.openURL("https://www.amazon.in");
		Keywords.maximizeBrowser();
		SignInPage signin = PageFactory.initElements(Constantss.driver,SignInPage.class);
		signin.clickSignin();
		signin.emailorPhone("nishan3d@gmail.com");
		signin.continueSignin();
		signin.password("********");
		signin.login();
		HomePage homepage = PageFactory.initElements(Constantss.driver, HomePage.class);
		homepage.check_Dropdown("Home & Kitchen");
		homepage.tabTosearch("Water purifier");
		homepage.searchButton();
		Keywords.downScrollBar();
		Keywords.takeScreenshot();
		Keywords.returnHomepage();
		Customerservicepage service=PageFactory.initElements(Constantss.driver,Customerservicepage.class);
		service.selectService();
		Keywords.downScrollBar();
		service.findmoreSolutions("delivery");
		Keywords.performAction("XPATH","//a[contains(text(),'Recommended Topics')]");
		Keywords.readJsonfile();
		Keywords.takeScreenshot();
		Keywords.applyWait();
		Keywords.returnHomepage();
		AmazonpayPage page=PageFactory.initElements(Constantss.driver, AmazonpayPage.class);
		page.selectElement();

	}
}