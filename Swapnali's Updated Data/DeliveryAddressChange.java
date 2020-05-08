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
		signin.enterPassword("****");
		signin.clickonLogin();
		signin.clickforAuthentication();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clickOnContinueForAuthentication();

		DeliveryAddressPOM addresschange = PageFactory.initElements(Constants.driver, DeliveryAddressPOM.class);
		addresschange.clickOnDeliveryTo();
		
		boolean isenabled=addresschange.isenabledAdress();
				
		if(isenabled=true) {
			
		addresschange.clickOnExistingAddtess();

		Constants.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		addresschange.clickOnDone();
		}else if (isenabled = false) {
			
			addresschange.ClickOnManageAddressBook();
			
			addresschange.clickOnAddAddress();
			
			System.out.println("Please enter new address");

			Keyword.selectValueFromDropdown("CLASS", "//*[@class=\"a-dropdown-prompt\"]", "India");
			
			Keyword.enterText("ID", "//*[@id=\"address-ui-widgets-enterAddressFullName\"]", "Swapnali Patil");

			Keyword.enterText("ID", "//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]", "9765028803");

			Keyword.enterText("ID", "//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]", "411002");

			Keyword.enterText("ID", "//*[@id=\"address-ui-widgets-enterAddressLine1\"]",
					"101, Gayatri Niwas, Thergona, Pune");

			Keyword.selectValueFromDropdown("ID", "//*[@id=\"address-ui-widgets-enterAddressCity\"]", "PUNE");
			
			Keyword.selectValueFromDropdown("XPATH", "//*[@id=\"address-ui-widgets-landmark\"]", "MAHARASHTRA");

			Keyword.clickonElement("CLASS", "//*[@class=\"a-button-input\"]");

			System.out.println("Your Delivery address is successfully updated");

		} else {
			System.out.println("Enetr Your enter a US zip code");
			addresschange.clickOnorEnteraUSZipCode();
			Keyword.enterText("XPATH", "//*[@id=\"GLUXZipUpdateInput\"]", "41100");
			addresschange.clickOnApply();
			System.out.println("You have sucessfully selected your current address");
		}

	}
}
