package com.testingshashtra.mylisteners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testingshashtra.utilities.ScreenShot;

public class MyListener implements ITestListener{
	public void onTestFailure(ITestResult result) {
		
		ScreenShot screenshot = new ScreenShot();
		try {
			screenshot.captureFullPageScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
