package Saucedemo_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Saucedemo_base.BaseforSauce;

public class HomePage extends BaseforSauce {
	
	
	@FindBy(xpath="//span[text()='Products']")
	private WebElement productlist;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement addcart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cartsymbol;
	
	public WebElement getProductlist() {
		return productlist;
	}
    public WebElement getAddcart() {
		return addcart;
	}

	public WebElement getCartsymbol() {
		return cartsymbol;
	}

   public HomePage() {
	
	   PageFactory.initElements(driver, this);
	   
   }
    public boolean getOnHomePage() {
		
		return getProductlist().isDisplayed();
	}
    
    public cartPage HomeAction() {
    	
        getAddcart().click();
    	getCartsymbol().click();
    	
    	return new cartPage();
    	
    }
	
    
    
}
