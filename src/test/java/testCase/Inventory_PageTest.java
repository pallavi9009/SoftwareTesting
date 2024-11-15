package testCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.Login;
import utility.ReadData;

public class Inventory_PageTest extends TestBase
{
	Login login;
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login=new Login();
		login.loginToApplication();
		invent=new Inventory_Page();
	}
	@Test(groups = {"Retest","Sanity"})
	public void verifyTitleOfInventoryPage() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,3); //"Swag Labs"(0,3)
		String actTitle=invent.verifyTitleOfInventoryPage();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(groups = "Sanity")
	public void verifyTwitterlogo()
	{
		boolean result = invent.verifyTwitterlogo();
		Assert.assertEquals(result, true);
	}
	@Test(groups = "Sanity")
	public void add8Products() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,4);//"6"(0,4)
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		
	}
	@Test(groups = "Sanity")
	public void remove2Products() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,5);//"4"(0,5)
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount,actCount);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{ 
		driver.close();
	}

}
