package democlass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerclass implements ITestListener{
	
	ExtentReports er;
	
	//It will monitor the Listener class example when it is starting ending
	ExtentTest  test;
	
	public void onTestStart(ITestResult result) {
		String name=result.getName();
		///particular test case monitor
		test = er.createTest(name);
		
	}

	
	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		test.log(Status.PASS,"name +------>Pass");
			}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		test.log(Status.FAIL,"name +------->Fail");
		
	}

	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		test.log(Status.SKIP, "name +------->skip");
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\Extents report\\"+1+".html");
		//to provide title of the report
		esr.config().setDocumentTitle("Final Vtiger Report");
		//providing the theme
		esr.config().setTheme(Theme.STANDARD);
		//providing the reporter name
		esr.config().setReportName("venky");
		//Extra relevant information about Report
		er = new ExtentReports();
		//it will match between ExtentSparkReorter and ExtentReport Objects
		er.attachReporter(esr);
		
		er.setSystemInfo("Operation System", "Window");
		
		er.setSystemInfo("Language", "Java");
		
		
	}

	public void onFinish(ITestContext context) {
		//it is going to consolidate the report
		er.flush();
		
	
	}

	

}
