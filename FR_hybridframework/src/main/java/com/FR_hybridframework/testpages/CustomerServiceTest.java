package com.FR_hybridframework.testpages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.pages.CustomerservicePage;
import com.FR_hybridframework.pages.SignInPage;
import com.FR_hybridframework.utilities.Custom_Listeners;

@Listeners(Custom_Listeners.class)
public class CustomerServiceTest extends Config_Test {
	
	@Test
	public void SearchCustomerService() {
		log.info("************************Test Customer Service page >> Search Query*******************************");
		SignInPage signin=PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);
		signin.mousehoverOnSignInTab();
		signin.clickonSignInTab();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clearUsername();
		signin.enterUsername("priyadeosarkar91@gmail.com");  //SenKeys >> emailId
		signin.continueToLogin();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clearPassword();
		signin.enterPassword("***");  //SenKeys >> Password
		signin.clickonLogin();
		signin.clickforAuthentication();
		Constants.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//Authentication required >> to handle OTP enter otp manually and proceed to continue
		
		//signin.clickOnContinueForAuthentication();

		Keyword.applyWaits();
		
		CustomerservicePage customerservice = PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), CustomerservicePage.class);
		customerservice.clickOnCustomerService();
		Keyword.downScrollBar();
		Keyword.applyWaits();
		customerservice.clickOnFindMoreSolutions("problem in signin");
		customerservice.hit_go();
		
	}
}
