package com.FR_hybridframework.testpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Constants;
import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.pages.HandleBuyProductPage;
import com.FR_hybridframework.pages.ProductPage;
import com.FR_hybridframework.pages.SignInPage;
import com.FR_hybridframework.utilities.Custom_Listeners;

@Listeners(Custom_Listeners.class)
public class All_PagesTestInOne extends Config_Test {
	
	@Test(priority = 1)
	public void verifyProductSelectionPageTest() {
		log.info("************************Test Product Selection Page*******************************");
		// 1. First done with Configure >> setup Test
		// 2. Verify signInTest

		// ***Expected to execute sign-in page first before product page

		ProductPage productPage = PageFactory.initElements(
				Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), ProductPage.class);
		productPage.enterTextToBeSearched("washing machine 7.5 kg");
		productPage.searchProduct();
		Constants.driver.switchTo().window(Constants.driver.getWindowHandle());
		Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		productPage.selectBrandsRefinements("2 Stars & Up");
		productPage.selectBrandsRefinements("Whirlpool");
		productPage.selectProductFromListByIndex();
		Constants.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		// System.out.println(Constants.driver.getTitle());
		productPage.productAddtoWishList();
	}

	@Test(priority = 2)
	public void signinTest() {
		log.info("************************Test SignIn Functionality*******************************");
		// First done with Configure >> setup Test

		SignInPage signin = PageFactory
				.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), SignInPage.class);
		signin.clearUsername();
		signin.enterUsername("priyadeosarkar91@gmail.com");
		signin.continueToLogin();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		signin.clearPassword();
		signin.enterPassword("charuDEVD");
		signin.clickonLogin();
//		 signin.clickforAuthentication();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		Assert.assertEquals(Constants.driver.getCurrentUrl(), "https://www.amazon.in/?ref_=nav_signin&");
	}

	@Test(priority = 3)
	public void verifyHandleBuyProductinWishListPage() {
		log.info("************************Verify Handle Buy Product in Wish List Page*******************************");
		// 1. First done with Configure >> setup Test
		// 2. Verify sign-In Test
		// 3. verify Product Selection Page Test

		// ***Expected to execute sign-in page, product selection page

		HandleBuyProductPage buyproduct = PageFactory.initElements(
				Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), HandleBuyProductPage.class);
//		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//		System.out.println(Constants.driver.getTitle());
		buyproduct.productAddtoWishList();
//		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		Keyword.getElementfrom("View Wish List").click();
		buyproduct.productSearchInWishList("Whirlpool 7.5 Kg 5 Star");
		buyproduct.keyAction();
		buyproduct.verifyProductinWishList();
//		boolean istitle = Keyword.getElementfrom(
//				"Whirlpool 7.5 kg 5 Star Semi-Automatic Top Loading Washing Machine (ACE SUPER SOAK 7.5, Coral Purple, Supersoak Technology)")
//				.isDisplayed();
//		Assert.assertEquals(true, istitle, "Product Mismatch");
	}

}
