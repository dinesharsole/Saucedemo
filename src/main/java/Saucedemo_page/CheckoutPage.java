package Saucedemo_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Saucedemo_base.BaseforSauce;

public class CheckoutPage extends BaseforSauce {
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement title;
	
	public WebElement getTitle() {
		return title;
	}
	 public CheckoutPage() {
		 PageFactory.initElements(driver, this);
	 }
	public boolean chekoutSuccessfully() {
		return getTitle().isDisplayed();
	}

}
