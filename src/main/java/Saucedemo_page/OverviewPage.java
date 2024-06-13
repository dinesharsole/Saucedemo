package Saucedemo_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Saucedemo_base.BaseforSauce;

public class OverviewPage extends BaseforSauce{
	
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	private WebElement overview;

	public WebElement getOverview() {
		return overview;
	}
	
	@FindBy(id="finish")
	private WebElement finis;
	public WebElement getFinis() {
		return finis;
	}
	
	public CheckoutPage overviewinformation() {
		
		getFinis().click();
		
		return new CheckoutPage();
		
	
		
	}

public OverviewPage() {
	PageFactory.initElements(driver, this);
	
	
}
	public boolean OverviewTitle() {
		
		return getOverview().isDisplayed();
	}

}
