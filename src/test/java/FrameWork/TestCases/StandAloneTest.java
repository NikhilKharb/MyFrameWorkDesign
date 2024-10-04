package FrameWork.TestCases;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import FrameWork.PageObjects.CartPage;
import FrameWork.PageObjects.CheckOutPage;
import FrameWork.PageObjects.HomePage;
import FrameWork.PageObjects.OrderSuccessPage;
import FrameWork.TestComponents.BaseTest;

public class StandAloneTest extends BaseTest {

	@Test(dataProvider = "getDataMap")
	public void submitOrder(HashMap<String, String> input) throws IOException {

		HomePage homePage = landingPage.login(input.get("email"), input.get("password"));
		homePage.getLoginMessage();
		homePage.getProds();
		homePage.addToCart(input.get("product"));
		CartPage cartPage = homePage.goToCart();
		Assert.assertTrue(cartPage.verifyProd().equalsIgnoreCase(input.get("product")));
		CheckOutPage chkoutPage = cartPage.checkOut();
		chkoutPage.enterCountry("Ind");
		chkoutPage.selectCountry("India");
		OrderSuccessPage cnfordrPage = chkoutPage.placeOrder();
		cnfordrPage.getToastMessage();
		String message = cnfordrPage.getSUccessMessage();

		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "nikhil.kharb@ymail.com", "Test@123", "ZARA COAT 3" },
				{ "nikhil.kharb@ymail.com", "Test@123", "IPHONE 13 PRO" } };
	}

	@DataProvider
	public Object[][] getDataMap() throws IOException {
//		HashMap<String, String> map = new HashMap<String, String>();
//
//		map.put("email", "nikhil.kharb@ymail.com");
//		map.put("password", "Test@123");
//		map.put("product", "ZARA COAT 3");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//
//		map1.put("email", "nikhil.kharb@ymail.com");
//		map1.put("password", "Test@123");
//		map1.put("product", "IPHONE 13 PRO");

		List<HashMap<String, String>> data = getJSONDataToMap(System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "test" + File.separator + "java" + File.separator + "FrameWork" + File.separator
				+ "TestData" + File.separator + "PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
