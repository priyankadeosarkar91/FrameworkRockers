package AmezonTestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Keyword.Keyword;
import com.Utilities.Constants;
import com.Utilities.Propertiesfile;

import PageModel.HomePage;
import PageModel.ReturnPage;
import PageModel.SignInPage;

class RetrunOrder {

	@Test
	public void OpenAmezonHomePage() {

		Keyword.openBrowser("Firefox");
		Keyword.openURL("https://www.amazon.in");

		SignInPage signin = PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);

		signin.mousehoverOnSignInTab();
		signin.clickonSignInTab();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		signin.enterUsername("swapnayawalkar@gmail.com");
		signin.continueToLogin();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		signin.enterPassword("Nilesh@123");
		signin.clickonLogin();
		signin.clickforAuthentication();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clickOnContinueForAuthentication();

		ReturnPage returnpage = PageFactory.initElements(Constants.driver, ReturnPage.class);
		returnpage.returnandorder();
		returnpage.order();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		returnpage.BuyAgain();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		returnpage.DigitalOrder();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		returnpage.cancelledOrder();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		returnpage.tabTosearchBox("Jwelary");
		
		returnpage.hit_Search();
	}
	
}
