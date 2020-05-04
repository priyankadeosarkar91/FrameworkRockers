package com.FR_hybridframework.testpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.pages.RegisterNewCustomerPage;
import com.FR_hybridframework.pages.SignInPage;
import com.FR_hybridframework.utilities.Custom_Listeners;

@Listeners(Custom_Listeners.class)
public class RegisterNewCustomerTest extends Config_Test {

	@Test
	public void verifyRegisterNewCustomer() {
		log.info("************************Test create new customer registeration*******************************");
		
		SignInPage signin=PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);
		signin.mousehoverOnSignInTab();
		signin.clickonSignInTab();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		RegisterNewCustomerPage newcustomer=PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), RegisterNewCustomerPage.class);
		newcustomer.clickOnCreateAccountTab();
		newcustomer.enterCustomerName("AutoTest");
		newcustomer.enterMobileNo("9518355701");
		newcustomer.setNewPassword("Auto@Test");
		newcustomer.clickOncontinue();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
