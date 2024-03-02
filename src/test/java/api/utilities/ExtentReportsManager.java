package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager implements ITestListener {
	public ExtentSparkReporter sparkReporter; // ui of reports
	public ExtentReports extent; // to specify common information we can add in reports like env, name , os
									// system
	public ExtentTest test; // creating enteries in reports

	String repName;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		repName = "Test-Reports-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); // specify the location of reports

		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
		sparkReporter.config().setReportName("Pen store Users API");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet Store Users API");
		extent.setSystemInfo("operating system", System.getProperty("os.name"));
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Saurabh");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());

	}

	public void OnTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());

	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	
}
