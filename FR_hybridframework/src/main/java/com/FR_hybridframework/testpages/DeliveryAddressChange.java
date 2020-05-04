package com.FR_hybridframework.testpages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.pages.DeliveryAddressPage;
import com.FR_hybridframework.pages.SignInPage;
import com.FR_hybridframework.utilities.Custom_Listeners;


@Listeners(Custom_Listeners.class)
public class DeliveryAddressChange extends Config_Test {
	
	boolean address;

	@Test
	public void AddressChangeRequest() throws InterruptedException {
		
		log.info("************************Test Address change Request*******************************");
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

		DeliveryAddressPage addresschange = PageFactory.initElements(Constants.driver, DeliveryAddressPage.class);
		addresschange.clickOnDeliveryTo();

		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		if (address = true) {
			System.out.println("Please enter new address");
			addresschange.ClickOnManageAddressBook();
			addresschange.clickOnAddAddress();

			Keyword.enterText("XPATH", "//*[@id=\"address-ui-widgets-enterAddressFullName\"]", "Swapnali Patil");

			Keyword.enterText("XATH", "//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]", "9765028803");

			Keyword.enterText("XPATH", "//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]", "411002");

			Keyword.enterText("Xpath", "//*[@id=\"address-ui-widgets-enterAddressLine1\"]",
					"101, Gayatri Niwas, Thergona, Pune");

			Keyword.selectValueFromDropdown("XPATH", "//*[@id=\"address-ui-widgets-landmark\"]", "MAHARASHTRA");

			Keyword.clickOnElement("Xpath", "//*[@id=\"a-autoid-0\"]/span/input");

			Keyword.clickOnElement("XPATH", "//*[@id=\"a-autoid-2\"]/span/input");

			System.out.println("You have chaged your address sucessfuly");

		} else {
			System.out.println("Enetr Your recent address PIN to changed you address");
			Keyword.enterText("XPATH", "//*[@id=\"GLUXZipUpdateInput\"]", "411002");
			addresschange.clickOnApply();
			System.out.println("You have sucessfully selected your current address");
		}

	}
}
