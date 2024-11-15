package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class Extent_Reports extends TestBase
{
	static ExtentReports report; //globally declared stay static
	public static ExtentReports getreportInstance()//create method
	{
		if(report==null)
		{
			String reportName=new SimpleDateFormat("dd-MM-YYYY  ss-mm-HH").format(new Date());//generate report
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("C:\\Users\\palla\\eclipse-workspace\\Selenium_Framework\\Extent Report//"+reportName+".html");//give anme & path
			report=new ExtentReports();//create object
			report.attachReporter(htmlReporter);//attached with html reporter
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Environment", "SIT");
			report.setSystemInfo("Build","102.02.02.123");
			report.setSystemInfo("Browser", "Chrome");
			htmlReporter.config().setDocumentTitle("UI Testing Documents");
			htmlReporter.config().setReportName("UI Test Report");
		}
		return report;
	}

}
