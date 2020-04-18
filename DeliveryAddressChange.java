package AmezonTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Keyword.Keyword;
import com.Utilities.Constants;

import PageModel.DeliveryAddressPOM;
import PageModel.ReturnPage;
import PageModel.SignInPage;

public class DeliveryAddressChange {
	boolean address;

	@Test
	public void AddressChangeRequest() throws InterruptedException {

		Keyword.openBrowser("Firefox");
		Keyword.openURL("https://www.amazon.in");

		SignInPage signin = PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);

		signin.mousehoverOnSignInTab();
		signin.clickonSignInTab();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		signin.enterUsername("swapnayawalkar@gmail.com");
		signin.continueToLogin();
		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		signin.enterPassword("*****");
		signin.clickonLogin();
		signin.clickforAuthentication();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clickOnContinueForAuthentication();

		DeliveryAddressPOM addresschange = PageFactory.initElements(Constants.driver, DeliveryAddressPOM.class);
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

			Keyword.clickonElement("Xpath", "//*[@id=\"a-autoid-0\"]/span/input");

			Keyword.clickonElement("XPATH", "//*[@id=\"a-autoid-2\"]/span/input");

			System.out.println("You have chaged your address sucessfuly");

		} else {
			System.out.println("Enetr Your recent address PIN to changed you address");
			Keyword.enterText("XPATH", "//*[@id=\"GLUXZipUpdateInput\"]", "411002");
			addresschange.clickOnApply();
			System.out.println("You have sucessfully selected your current address");
		}

	}
}
