package com.framework_PDD.amazon.tests;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework_PDD.keywords.Constants;
import com.framework_PDD.keywords.Keyword;
import com.framework_PDD.pages.HandleBuyProductPage;

public class HandleBuyProductTest {
	
	@Test
	public void verifyBuyProductinWishList() {
		
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
