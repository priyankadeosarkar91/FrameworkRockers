package com.FR_hybridframework.tests;


import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.testpages.Config_Test;
import com.FR_hybridframework.utilities.Custom_Listeners;
import com.FR_hybridframework.utilities.Logged1;

@Listeners(Custom_Listeners.class)
public class Test_Smoke extends Config_Test {
	
	static final Logger log = Logger.getLogger(Logged1.class);
	
	@Test
	public void Testcase_ValideUsername_InvalidePassword() {
		log.info("************************Start executing smoke test for >> Sign in*******************************");
		log.info("************************Testcase_ValideUsername_InvalidePassword*******************************");
		
		Keyword.clickOnElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
		Keyword.enterText("CSS", "#email", "swapnayawalkar@gmail.com");
		Keyword.clickOnElement("CSS", "#continue");
		Keyword.enterText("CSS", "#pass", "Test@123");
		Keyword.clickOnElement("CSS", "#signInSubmit");
		System.out.println("Please Enter Valide Password");
	}
	
	@Test
	public void Testcase_IvValideUsername_InvalidePassword() {
		log.info("************************Testcase_IvValideUsername_InvalidePassword*******************************");
		
		Keyword.clickOnElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
		Keyword.enterText("CSS", "#email", "swapnaliyawalkar@gmail.com");
		Keyword.clickOnElement("CSS", "#continue");
		Keyword.enterText("CSS", "#pass", "Test@123");
		Keyword.clickOnElement("CSS", "#signInSubmit");
		System.out.println("Please Enter Valide Username & Password");
	}	
	
	@Test
	public void Testcase_InValideUsername_validePassword() {
		log.info("************************Testcase_InValideUsername_validePassword*******************************");
		
		Keyword.clickOnElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
		Keyword.enterText("CSS", "#email", "swapnaliyawalkar@gmail.com");
		Keyword.clickOnElement("CSS", "#continue");
		Keyword.enterText("CSS", "#pass", "Nilesh@123");
		Keyword.clickOnElement("CSS", "#signInSubmit");
		System.out.println("Please Enter Valide Username");
		
	}
	
	@Test
	public void Testcase_ValideUsername_validePassword() {
		log.info("************************Testcase_ValideUsername_validePassword*******************************");
		
		Keyword.clickOnElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
		Keyword.enterText("CSS", "#email", "swapnayawalkar@gmail.com");
		Keyword.clickOnElement("CSS", "#continue");
		Keyword.enterText("CSS", "#pass", "Nilesh@123");
		Keyword.clickOnElement("CSS", "#signInSubmit");
		System.out.println("You are successfully Login");
	}
	
	
}
