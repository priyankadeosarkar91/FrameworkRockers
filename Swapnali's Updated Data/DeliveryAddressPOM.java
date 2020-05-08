package PageModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.Utilities.Constants;

public class DeliveryAddressPOM {
	@FindBy(id = "//*[@id='glow-ingress-line1']")
	WebElement clickOnDeliveryTo;
	
	@FindBy(xpath = "//*[@id=\"GLUXAddressList\"]/li[2]/span/span/span/input")
	WebElement clickOnexistingAddtess;
	
	@FindBy(name = "//*[@name=\"glowDoneButton\"]")
	WebElement clickOnDone;
	
	@FindBy(id = "//*[@id=\"GLUXManageAddressLink\"]")
	WebElement clickOnManagerAddressBook;
	
	@FindBy(id = "//*[@id=\"ya-myab-plus-address-icon\"]")
	WebElement clickOnAddAddress;
	
	@FindBy(id = "//*[@id=\"GLUXZipUpdateInput\"]")
	WebElement clickOnorEnteraUSzipcode;
	
	@FindBy(xpath = "//*[@id=\"GLUXZipUpdate\"]/span/input")
	WebElement clickOnApply;
	
	
	public void clickOnDeliveryTo() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnDeliveryTo).click().perform();
	}	
	
	public void clickOnExistingAddtess() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnexistingAddtess).click().perform();
	}	
	
	public void clickOnDone() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnDone).click().perform();
	}
	
	public void ClickOnManageAddressBook() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnManagerAddressBook).click().perform();
	}
	
	
	public void clickOnAddAddress() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnAddAddress).click().perform();
	}
	
	public void clickOnorEnteraUSZipCode() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnorEnteraUSzipcode).click().perform();
	}
	
	public void clickOnApply() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnApply).click().perform();
	}
	
	public boolean isenabledAdress() {
		boolean isenabled=clickOnexistingAddtess.isEnabled();
		return isenabled;
		
	}
	
	
	
}


