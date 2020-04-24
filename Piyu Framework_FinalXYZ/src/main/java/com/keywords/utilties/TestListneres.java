package com.keywords.utilties;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.keywords.Keyword;

public class TestListneres implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of test case onstart of test" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test case on testsuccess" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test case failed " + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of testcase skipped " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Take screenshot on Test Failed");
		try {
			Keyword.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
