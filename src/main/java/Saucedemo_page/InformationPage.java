package Saucedemo_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Saucedemo_base.BaseforSauce;

public class InformationPage extends BaseforSauce {
	
	@FindBy(xpath="//span[text()='Checkout: Your Information']")
	private WebElement infopage;
	public WebElement getInfopage() {
		return infopage;
	}
	@FindBy(id="first-name")
	private WebElement firstname;
	

    @FindBy(id="last-name")
	private WebElement lastname;
	
	@FindBy(id="postal-code")
	private WebElement postalcode;
	@FindBy(id="continue")
	private WebElement contin;
	public WebElement getContin() {
		return contin;
	}
	
	
	
	
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPostalcode() {
		return postalcode;
	}

	
	public InformationPage() {
		PageFactory.initElements(driver, this);
	}

	public OverviewPage info(String firstname,String lastname, String postalcode ) {
		getFirstname().sendKeys(firstname);
		getLastname().sendKeys(lastname);
		getPostalcode().sendKeys(postalcode);
		getContin().click();
		//getTitle().isDisplayed();
		
		return new OverviewPage();
		
		
		
		
	}
	public boolean infoPage() {
		return  getInfopage().isDisplayed();
		
		
	}
}
