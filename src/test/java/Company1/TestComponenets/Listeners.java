package Company1.TestComponenets;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Company1.Resources.ExtentReporterNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;


public class Listeners extends BaseTest implements ITestListener {
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result)
	{
		test =extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		extentTest.get().log(Status.PASS, "Test Passed");	
	 System.out.println("pass  -"+result.getMethod().getMethodName());

	}
	@Override
	public void onTestFailure(ITestResult result)
	{
	//test.log(Status.FAIL, "Test failed");
	
	String filepath = null;
	 System.out.println("fail   -"+result.getMethod().getMethodName());

	 extentTest.get().fail(result.getThrowable());
	try {
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	try {
		 filepath=getScreenShot(result.getMethod().getMethodName(),driver);
		 System.out.println("filepath - "+filepath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	
	}

	@AfterTest(alwaysRun = true)
	@Override
	public 	void onFinish(ITestContext context) {
	    // not implemented
		extent.flush();

	  }
	
	
}
