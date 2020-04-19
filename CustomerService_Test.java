package AmezonTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Keyword.Keyword;
import com.Utilities.Constants;

import PageModel.Customerservicepage;
import PageModel.ReturnPage;
import PageModel.SignInPage;

public class CustomerService_Test {
	@Test
	public void SearchCustomerService() {
		Keyword.openBrowser("Firefox");
		Keyword.openURL("https://www.amazon.in");

		SignInPage signin = PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);

		signin.mousehoverOnSignInTab();
		signin.clickonSignInTab();
		
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		signin.enterUsername("swapnayawalkar@gmail.com");
		signin.continueToLogin();
		
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		signin.enterPassword("*******");
		
		signin.clickonLogin();
		
		signin.clickforAuthentication();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clickOnContinueForAuthentication();

		Keyword.applyWaits();
		
		Customerservicepage customerservice = PageFactory.initElements(Constants.driver, Customerservicepage.class);
		
		customerservice.clickOnCustomerService();
		
		Keyword.downScrollBar();
		
		Keyword.applyWaits();
		
		customerservice.clickOnFindMoreSolutions("Problem in Sign in");
		
		customerservice.hit_go();
		
	}
}
