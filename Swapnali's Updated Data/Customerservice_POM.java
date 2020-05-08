package PageModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.Utilities.Constants;

public class Customerservice_POM {
	@FindBy(xpath = "/html/body/div[1]/header/div/div[3]/div[3]/div/div/a[2]")
	static WebElement customerservice_tab;

	@FindBy(xpath = "//input[@type=\"search\"]")
	static WebElement FindMoreSolutions;

	@FindBy(xpath = "//input[@class=\"a-button-input\"]")
	static WebElement go_tab;

	public void clickOnCustomerService() {
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(customerservice_tab).click().perform();

	}

	public void clickOnFindMoreSolutions(String value) {
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(FindMoreSolutions).click().perform();

		
	}

	public void hit_go() {
		go_tab.click();
	}

}
