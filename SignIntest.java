package com.hybridframework.amazon.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hybridframework.keywords.Constants;
import com.hybridframework.keywords.Keyword;
import com.hybridframework.pages.SignInPage;





public class SignIntest{
	
	@Test
	public void loginTest2() {
		Keyword.openBrowser("Chrome");
		Keyword.openURL("https://www.amazon.in");
		
//		Keyword.openURL("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

//		Constants.action=new Actions(Constants.driver);
//		WebElement element=Keyword.getElementfrom("CSS", "a#nav-link-accountList>span");
//		Constants.action.moveToElement(element).click().perform();
	
		
		SignInPage signin=PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);
		signin.mousehoverOnSignInTab();
		signin.clickonSignInTab();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		signin.clearUsername();
		signin.enterUsername("priyadeosarkar91@gmail.com");
		signin.continueToLogin();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		signin.clearPassword();
		signin.enterPassword("****");
		signin.clickonLogin();
	}
	
	

}
