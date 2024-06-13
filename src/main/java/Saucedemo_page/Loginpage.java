package Saucedemo_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Saucedemo_base.BaseforSauce;

public class Loginpage extends BaseforSauce {
	
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement userName;

	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement submitbtn;
	@FindBy(xpath="//div[@class='error-message-container error']")
	private WebElement errormsg;
	

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	public WebElement getErrormsg() {
		return errormsg;
	}
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage doLogin(String username,String password) {
		getUserName().sendKeys(username);
		getPassword().sendKeys(password);
		getSubmitbtn().click();
		 return new HomePage();
	}
	
	public boolean invalidLogin(String invalidusername,String invalidpassword) {
		getUserName().sendKeys(invalidusername);
		getPassword().sendKeys(invalidpassword);
		getSubmitbtn().click();
		return getErrormsg().isDisplayed();
		
	}
	
}