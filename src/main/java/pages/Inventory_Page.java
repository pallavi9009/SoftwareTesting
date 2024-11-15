package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDownList;

public class Inventory_Page extends TestBase
{
	//object repository
	//add product
	@FindBy(xpath="//span[text()='Products']")private WebElement productLable;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']")private WebElement bakpackProduct;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-bike-light']")private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@name=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")private WebElement tshirtProduct;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-fleece-jacket']")private WebElement JacketProduct;
	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-onesie\"]")private WebElement onesieProduct;
	@FindBy(xpath="//button[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")private WebElement redtshirtProduct;
	//remove product
	@FindBy(xpath="//button[@id=\"remove-sauce-labs-onesie\"]")private WebElement removeOnesieProduct;
	@FindBy(xpath="//button[@id=\"remove-sauce-labs-bike-light\"]")private WebElement removeBikeLightProduct;
	
	@FindBy(xpath="//li[@class='social_twitter']")private WebElement twitterlogo;
	@FindBy(xpath="//select[@class='product_sort_container']")private WebElement dropdownlist;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement cartcount;
	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]")private WebElement cartIcon;
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyTitleOfInventoryPage()
	{
		return driver.getTitle();
	}
	public boolean verifyTwitterlogo()
	{
		return twitterlogo.isDisplayed();
		
	}
	public String add6Products()
	{
		HandleDropDownList.handlelistBox(dropdownlist, "Price (low to high)");
		bakpackProduct.click();
		bikeLightProduct.click();
		tshirtProduct.click();
		JacketProduct.click();
		onesieProduct.click();
		redtshirtProduct.click();
		return cartcount.getText();
		
	}
	public String remove2Products()
	{
		add6Products();//calling add product method
		removeOnesieProduct.click();
		removeBikeLightProduct.click(); 
		return  cartcount.getText();
	}
	public void clickonCartIcon()
	{
		cartIcon.click();
	}
	
	

}
