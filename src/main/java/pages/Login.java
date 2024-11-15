package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class Login extends TestBase
{
	//object repository
	//in framework annotation used
	@FindBy(xpath="//input[@id='user-name']")private WebElement usernameTxtBox;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@id='login-button']")private WebElement loginBtn;
	public Login()
	{
		 PageFactory.initElements(driver, this); //constructer which is call method
	}
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login into the sauce lab Appliaction");
		usernameTxtBox.sendKeys(ReadData.readPropertyfile("Username"));
		logger.log(Status.INFO, "user is entered");
		passwordTxtBox.sendKeys(ReadData.readPropertyfile("password"));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.INFO,"Login button is clicked");
		logger.log(Status.PASS, "Login Sucessfull");
		return driver.getCurrentUrl();//https://www.saucedemo.com/inventory.html
	}
	public String verifyMulticreds(String username,String password)
	{
		usernameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		return driver.getCurrentUrl();//https://www.saucedemo.com/inventory.html
	}
	
	
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
		
	}
}
