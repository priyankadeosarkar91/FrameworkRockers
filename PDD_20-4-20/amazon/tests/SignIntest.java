package com.framework_PDD.amazon.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework_PDD.keywords.Constants;
import com.framework_PDD.pages.SignInPage;




public class SignIntest{
	
	@Test
	public void loginTest() {
		//Configure setup is in class >>> Config_test.java
		
		SignInPage signin=PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);
		//signin.mousehoverOnSignInTab();
		//signin.clickonSignInTab();
		//Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clearUsername();
		signin.enterUsername("priyadeosarkar91@gmail.com");
		signin.continueToLogin();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clearPassword();
		signin.enterPassword("***");
		signin.clickonLogin();
//		signin.clickonAuthenticationLogin();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
