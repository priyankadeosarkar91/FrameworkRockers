package com.FR_hybridframework.testpages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.pages.SignOutPage;
import com.FR_hybridframework.utilities.Custom_Listeners;

@Listeners(Custom_Listeners.class)
public class SignOutTest extends SignIntest {
	@Test
	public void signoutTest() {
		log.info("************************Test SihgnOut fuctionality*******************************");
		SignOutPage signout = PageFactory.initElements(
				Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignOutPage.class);
		signout.mousehoverOnAccountTab();
		signout.clickonSignoutTab();

	}
}
