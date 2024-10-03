package FrameWork.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWork.PageObjects.CartPage;
import FrameWork.PageObjects.CheckOutPage;
import FrameWork.PageObjects.HomePage;
import FrameWork.PageObjects.OrderSuccessPage;
import FrameWork.TestComponents.BaseTest;

public class StandAloneTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException {

		HomePage homePage = landingPage.login("nikhil.kharb@ymail.com", "Test@123");
		homePage.getLoginMessage();
		homePage.getProds();
		homePage.addToCart("ZARA");
		CartPage cartPage = homePage.goToCart();
		Assert.assertTrue(cartPage.verifyProd().equalsIgnoreCase("ZARA COAT 3"));
		CheckOutPage chkoutPage = cartPage.checkOut();
		chkoutPage.enterCountry("Ind");
		chkoutPage.selectCountry("India");
		OrderSuccessPage cnfordrPage = chkoutPage.placeOrder();
		cnfordrPage.getToastMessage();
		String message = cnfordrPage.getSUccessMessage();
		System.out.println(message);
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();
	}

}
