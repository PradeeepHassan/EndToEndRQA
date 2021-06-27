package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterEndToEnd {
	
	static ExtentReports extent;
	public static ExtentReports getReports() {
	
	String path =System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("End To End Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	 extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Pradeep");
	return extent;

	}
}
