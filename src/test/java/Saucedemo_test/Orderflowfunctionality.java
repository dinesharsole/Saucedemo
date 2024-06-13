package Saucedemo_test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Saucedemo_base.BaseforSauce;
import Saucedemo_page.CheckoutPage;
import Saucedemo_page.HomePage;
import Saucedemo_page.InformationPage;
import Saucedemo_page.Loginpage;
import Saucedemo_page.OverviewPage;
import Saucedemo_page.cartPage;

public class Orderflowfunctionality extends BaseforSauce {

	Loginpage login;
	HomePage homep;
	

	@BeforeMethod
	void setup() {
		initialization();
		login = new Loginpage();
		
	}

	@Test(priority=1)
	public void Verify_Login_With_Valid_Credentials() {

		String user = props.getProperty("username");
		String pass = props.getProperty("password");

		HomePage home = login.doLogin(user, pass);
        
		boolean isHomePage = home.getOnHomePage();
		Assert.assertTrue(isHomePage, "Home pages is not displayed");

	}

	@Test(priority=2)
	public void Verify_Login_With_invalidcredentials() {
		String inusern = props.getProperty("invalidusername");
		String inpass = props.getProperty("invalidpassword");

		boolean msg = login.invalidLogin(inusern, inpass);
		Assert.assertTrue(msg, "msg is not displayed");

	}

	@Test(priority=3)
	public void Verify_addcart_button_functionality() {
		String user = props.getProperty("username");
		String pass = props.getProperty("password");

		HomePage home = login.doLogin(user, pass);

		cartPage cart = home.HomeAction();
		boolean iscartpage = cart.getCartDetails();

		Assert.assertTrue(iscartpage, "Cart Page is not displayed");
	}

	@Test(priority=4)
	public void verify_removeb_button_functionality() {
		String user = props.getProperty("username");
		String pass = props.getProperty("password");

		HomePage home = login.doLogin(user, pass);

		cartPage cart = home.HomeAction();
		InformationPage in = cart.cartAction();
		boolean isinfopage = in.infoPage();
		Assert.assertTrue(isinfopage, "info Page is not displayed");
	}

//
	@Test(priority=5)
	public void Verify_User_navigating_from_informationpage_to_OverviewpageofUser() {
		String user = props.getProperty("username");
		String pass = props.getProperty("password");
		String fname = props.getProperty("firstname");
		String lname = props.getProperty("lastname");
		String pcode = props.getProperty("postalcode");

		HomePage home = login.doLogin(user, pass);

		cartPage cart = home.HomeAction();
		InformationPage in = cart.cartAction();
		OverviewPage op = in.info(fname, lname, pcode);
		boolean isoverviewtitle = op.OverviewTitle();
		Assert.assertTrue(isoverviewtitle, "Overview page is not displayed");
	}

	@Test(priority=6)
	public void Verify_When_User_clickon_finishbutton_of_overviewpage_user_should_Checkout_successfully() {
		
		String user = props.getProperty("username");
		String pass = props.getProperty("password");
		String fname = props.getProperty("firstname");
		String lname = props.getProperty("lastname");
		String pcode = props.getProperty("postalcode");

		HomePage home = login.doLogin(user, pass);

		cartPage cart = home.HomeAction();
		InformationPage in = cart.cartAction();
		OverviewPage op = in.info(fname, lname, pcode);
		  CheckoutPage check= op.overviewinformation();
		  boolean ischeckout=check.chekoutSuccessfully();
		  
		  Assert.assertTrue(ischeckout, "Checkout page is not displayed");
		
		  System.out.println("User has successfully completed the flow of Add and remove product from cart");

	}
    @AfterMethod
	void closeAll() {
    	teardown();
    }
    
}
