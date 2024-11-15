package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Extent_Reports;
import utility.ReadData;

public class TestBase
{
	public ExtentReports report=Extent_Reports.getreportInstance();
	public ExtentTest logger;
	public static WebDriver driver; //global variable
	public void  initialization() throws IOException
	{
		String browser=ReadData.readPropertyfile("BROWSER");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();//accesing chrome driver
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver();
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyfile("URL"));	
		
	}

}
