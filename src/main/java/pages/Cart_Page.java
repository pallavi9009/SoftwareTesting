package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	//object Repository
	@FindBy(xpath="//span[@class=\"title\"]")private WebElement cartLable;
	@FindBy(xpath="//button[@id=\"checkout\"]")private WebElement checkoutBtn;
	@FindBy(xpath="//button[@id=\"continue-shopping\"]") private WebElement continueShoppingBtn;
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String verifyCheckOutBtn()
	{
		checkoutBtn.click();
		return driver.getCurrentUrl();//https://www.saucedemo.com/checkout-step-one.html
		
	}

}
