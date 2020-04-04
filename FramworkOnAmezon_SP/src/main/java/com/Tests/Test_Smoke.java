package com.Tests;

import org.testng.annotations.Test;

import com.Keyword.Keyword;

public class Test_Smoke {
	public void AmezonLogin() {
		Keyword.openBrowser("Chrome");
		Keyword.openURL("https://www.amazon.com");
	}
	@Test
	public void Testcase_ValideUsername_InvalidePassword() {
		Keyword.clickonElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
		Keyword.enterText("CSS", "#email", "swapnayawalkar@gmail.com");
		Keyword.clickonElement("CSS", "#continue");
		Keyword.enterText("CSS", "#pass", "Test@123");
		Keyword.clickonElement("CSS", "#signInSubmit");
		System.out.println("Please Enter Valide Password");
	}
	
	@Test
	public void Testcase_IvValideUsername_InvalidePassword() {
		Keyword.clickonElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
		Keyword.enterText("CSS", "#email", "swapnaliyawalkar@gmail.com");
		Keyword.clickonElement("CSS", "#continue");
		Keyword.enterText("CSS", "#pass", "Test@123");
		Keyword.clickonElement("CSS", "#signInSubmit");
		System.out.println("Please Enter Valide Username & Password");
	}	
	
	@Test
	public void Testcase_InValideUsername_validePassword() {
		Keyword.clickonElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
		Keyword.enterText("CSS", "#email", "swapnaliyawalkar@gmail.com");
		Keyword.clickonElement("CSS", "#continue");
		Keyword.enterText("CSS", "#pass", "Nilesh@123");
		Keyword.clickonElement("CSS", "#signInSubmit");
		System.out.println("Please Enter Valide Username");
		
	}
	
	@Test
	public void Testcase_ValideUsername_validePassword() {
		Keyword.clickonElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
		Keyword.enterText("CSS", "#email", "swapnayawalkar@gmail.com");
		Keyword.clickonElement("CSS", "#continue");
		Keyword.enterText("CSS", "#pass", "Nilesh@123");
		Keyword.clickonElement("CSS", "#signInSubmit");
		System.out.println("You are successfully Login");
	}
	
	
}
