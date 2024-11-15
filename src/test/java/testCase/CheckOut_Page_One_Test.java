package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_Page_One;
import pages.Inventory_Page;
import pages.Login;

public class CheckOut_Page_One_Test extends TestBase
{
	Login login;
	Inventory_Page invent;
	Cart_Page cart;
	CheckOut_Page_One check;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login=new Login();//create login object
		login.loginToApplication();
		invent=new Inventory_Page();
		invent.add6Products();
		invent.clickonCartIcon();
		cart=new Cart_Page();
		cart.verifyCheckOutBtn();
		check=new CheckOut_Page_One();//create check object
		
	}
	@Test(groups = "Sanity")
	public void verifyCheckLableTest()
	{
		String expLable="Checkout: Your Information";
		String actLable=check.verifyCheckLable();
		Assert.assertEquals(expLable, actLable);
	}
	@Test(groups = "Sanity")
	public void inputInformation()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check.inputInformation();
		Assert.assertEquals(expURL, actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{ 
		driver.close();
	}


}
