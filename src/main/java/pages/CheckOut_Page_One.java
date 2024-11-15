package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Page_One extends TestBase
{
	@FindBy(xpath="//span[text()=\"Checkout: Your Information\"]")private WebElement checkLable;
	@FindBy(xpath="//input[@id=\"first-name\"]")private WebElement FirstnameTextBox;
	@FindBy(xpath="//input[@id=\"last-name\"]")private WebElement LastnameTextBox;
	@FindBy(xpath="//input[@id=\"postal-code\"]")private WebElement ZipcodeBox;
	@FindBy(xpath="//input[@id=\"continue\"]")private WebElement ContinueBtn;
	
	public CheckOut_Page_One()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCheckLable()
	{
		return checkLable.getText();
	}
	public String inputInformation()
	{
		FirstnameTextBox.sendKeys("Pallavi");
		LastnameTextBox.sendKeys("Bhavar");
		ZipcodeBox.sendKeys("423603");
		ContinueBtn.click();
		return driver.getCurrentUrl();
	}
	
	

}
