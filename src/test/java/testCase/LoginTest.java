package testCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.Login;
import utility.ReadData;
import utility.Screenshot;

public class LoginTest extends TestBase
{
	Login login;
	@BeforeMethod(alwaysRun= true)
	public void setUp() throws IOException
	{
		initialization();
		login=new Login();
	}
	
	@Test (priority = 1,enabled = true,groups = "Sanity")
	public void  verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,0);  //"https://www.saucedemo.com/"(0,0)
		String actURL=login.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log(" The URL of swag labs Page = " + actURL);
	}
	
	@Test(priority = 2,enabled = true,groups = {"Retest","Regression"}/*dependsOnMethods = "verifyURLOfApplicationTest"*/)
	public void verifyTitleOfApplication() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,1); //"Swag Labs"(0,1)
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(" Title of swag labs page = " + actTitle);
	}
	@Test (priority = 3,enabled = true,groups ="Regression" /*dependsOnMethods = "verifyURLOfApplicationTest"*/ )
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0,2);  //"https://www.saucedemo.com/inventory.html"(0,2 )
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Login Successful = " + actURL);
	}
	/*@Test(dataProvider = "testData")
	public void verifyMulticredsTest(String username,String password )
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.verifyMulticreds(username, password);
		s.assertEquals(expURL, actURL);
		s.assertAll();
		
	} */
	@DataProvider(name="testData")
	public Object [][] getData()
	{
		return new Object[][]
				{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
			
				};
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult it) throws IOException
	{ 
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		report.flush();
		driver.close();
	}
	
}
