package Saucedemo_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Saucedemo_base.BaseforSauce;

public class cartPage extends BaseforSauce {
	@FindBy(xpath="//span[text()='Your Cart']")
	private WebElement cartPage;
	
	

	@FindBy(xpath="//button[@name='remove-sauce-labs-backpack']")
    private WebElement removebtn;
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkoutbtn;

	public WebElement getRemovebtn() {
		return removebtn;
	}

	public WebElement getCheckoutbtn() {
		return checkoutbtn;
	}
	public WebElement getCartPage() {
		return cartPage;
	}
	
	public cartPage() {
		PageFactory.initElements(driver, this);
		
	}
	
		
	
	
	public InformationPage cartAction() {
		 getRemovebtn().click();
		 getCheckoutbtn().click();
		 
		 return new InformationPage();
		
	}

	public boolean getCartDetails() {
		
		return getCartPage().isDisplayed();
	}

}
