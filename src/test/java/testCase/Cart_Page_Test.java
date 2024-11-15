package testCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Inventory_Page;
import pages.Login;
import utility.ReadData;

public class Cart_Page_Test extends TestBase
{
	Login login;
	Inventory_Page invent;
	Cart_Page cart;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login=new Login();
		login.loginToApplication();
		invent=new Inventory_Page();
		invent.add6Products();
		invent.clickonCartIcon();
		cart=new Cart_Page();
		
		
	}
	@Test(groups = "Sanity")
	public void verifyCheckOutBtnTest() throws EncryptedDocumentException, IOException
	{
		{

			String expURL=ReadData.readExcel(0,6);//"https://www.saucedemo.com/checkout-step-one.html"(0,5)
			String actURL=cart.verifyCheckOutBtn();
			Assert.assertEquals(expURL,actURL);
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{ 
		driver.close();
	}


}
