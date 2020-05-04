package com.FR_hybridframework.testpages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.pages.SignInPage;
import com.FR_hybridframework.utilities.Custom_Listeners;

@Listeners(Custom_Listeners.class)
public class SignIntest extends Config_Test{
	
	@Test
	public void loginTest() {
		log.info("************************Test SihgnIn fuctionality*******************************");
		
		//Configure setup is in class >>> Config_test.java
		
		SignInPage signin=PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);
		signin.mousehoverOnSignInTab();
		signin.clickonSignInTab();
		Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		signin.clearUsername();
		signin.enterUsername("priyadeosarkar91@gmail.com");  //SenKeys >> emailId
		signin.continueToLogin();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clearPassword();
		signin.enterPassword("charuDEVD");  //SenKeys >> Password
		signin.clickonLogin();
		//signin.clickforAuthentication();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
