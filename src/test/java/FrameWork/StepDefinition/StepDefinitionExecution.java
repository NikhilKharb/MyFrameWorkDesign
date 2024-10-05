package FrameWork.StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import FrameWork.PageObjects.CartPage;
import FrameWork.PageObjects.CheckOutPage;
import FrameWork.PageObjects.HomePage;
import FrameWork.PageObjects.LandingPage;
import FrameWork.PageObjects.OrderSuccessPage;
import FrameWork.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionExecution extends BaseTest {

	public HomePage homePage;
	public LandingPage landingPage;
	public String message;

	@Given("I landed on the application")
	public void I_landed_on_the_application() throws IOException {
		landingPage = launchApplication();

	}

	@Given("^Login with the username (.+) and password (.+)$")
	public void logged_in(String name, String password) {
		homePage = landingPage.login(name, password);

	}

	@When("^I added the (.+) to Cart$")
	public void addedToCart(String prod) {
		homePage.getLoginMessage();
		homePage.getProds();
		homePage.addToCart(prod);
	}

	@And("^Checkout (.+) to Cart$")
	public void checkoutToCart(String prod) {
		CartPage cartPage = homePage.goToCart();
		Assert.assertTrue(cartPage.verifyProd().equalsIgnoreCase(prod));
		CheckOutPage chkoutPage = cartPage.checkOut();
		chkoutPage.enterCountry("Ind");
		chkoutPage.selectCountry("India");
		OrderSuccessPage cnfordrPage = chkoutPage.placeOrder();
		cnfordrPage.getToastMessage();
		message = cnfordrPage.getSUccessMessage();

	}

	@Then("{string} message is diplayed on ConfirmationPage")
	public void conf_order(String string) {
		Assert.assertTrue(message.equalsIgnoreCase(string));
		driver.close();
	}
}
