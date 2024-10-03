package FrameWork.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameWork.PageObjects.HomePage;
import FrameWork.PageObjects.LandingPage;
import FrameWork.TestComponents.BaseTest;

public class LoginTestCases extends BaseTest {

//	@Test
//	public void logintest_001_valid_creds() throws IOException {
//
//		HomePage homePage = landingPage.login("nikhil.kharb@ymail.com", "Test@123");
//		String message = homePage.getLoginMessage();
//		Assert.assertTrue(message.equalsIgnoreCase("Login Successfully"));
//
//	}

	@Test(groups = { "negative" }, dataProvider = "getloginData")
	public void logintest_002_valid_email_invalid_pass(HashMap<String, String> input) throws IOException {

		HomePage homePage = landingPage.login(input.get("email"), input.get("password"));
		String message = homePage.getLoginMessage();
		Assert.assertEquals(input.get("message"),message);
		System.out.println(input.get("type"));

	}

//	@Test(groups= {"negative"},dataProvider = "getDataMap")
//	public void logintest_003_invalid_email_valid_pass() throws IOException {
//
//		HomePage homePage = landingPage.login("nikhil.kharb@yuiymail.com", "Test@123");
//		String message = homePage.getLoginMessage();
//		Assert.assertTrue(message.equalsIgnoreCase("Incorrect email or password."));
//
//	}
	@DataProvider
	public Object[][] getloginData() throws IOException {
		List<HashMap<String, String>> data = getJSONDataToMap(System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "test" + File.separator + "java" + File.separator + "FrameWork" + File.separator
				+ "TestData" + File.separator + "LoginDataValidation.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
	

}
