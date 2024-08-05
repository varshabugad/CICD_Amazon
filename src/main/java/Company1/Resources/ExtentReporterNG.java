package Company1.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		String path= System.getProperty("user.dir")+"\\ReportsIndex\\index.html";
		System.out.println(path);

		//ExtentHtmlReporter reporter= new ExtentHtmlReporter(path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Reports");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Varsha");
		 return extent;
	}

}
