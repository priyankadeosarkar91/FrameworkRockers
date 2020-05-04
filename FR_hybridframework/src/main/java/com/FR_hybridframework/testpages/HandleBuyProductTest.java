package com.FR_hybridframework.testpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.pages.HandleBuyProductPage;
import com.FR_hybridframework.utilities.Custom_Listeners;

@Listeners(Custom_Listeners.class)
public class HandleBuyProductTest extends Config_Test {
	
	@Test
	public void verifyBuyProductinWishList() {
		//Configure setup is in class >>> Config_test.java
		
		//Expected to execute product page
		log.info("************************Verify Buy Product in Wish List*******************************");
		HandleBuyProductPage buyproduct=PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), HandleBuyProductPage.class);
		Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println(Constants.driver.getTitle());
		buyproduct.productAddtoWishList();
		Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Keyword.getElementfrom("View Wish List").click();
		buyproduct.productSearchInWishList("Whirlpool 7.5 Kg 5 Star");
		buyproduct.keyAction();
		buyproduct.verifyProductinWishList();
//		Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//		Keyword.getElementfrom("Quick View").click();
		boolean istitle=Keyword.getElementfrom("Whirlpool 7.5 Kg 5 Star Fully-Automatic Top Loading Washing Machine (WHITEMAGIC ELITE 7.5, Grey, Hard Water Wash)").isDisplayed();
		Assert.assertEquals(true, istitle,"Product Mismatch");
	}
	
}
