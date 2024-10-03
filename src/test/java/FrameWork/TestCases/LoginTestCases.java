package FrameWork.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWork.PageObjects.HomePage;
import FrameWork.PageObjects.LandingPage;
import FrameWork.TestComponents.BaseTest;

public class LoginTestCases extends BaseTest {

	@Test
	public void logintest_001_valid_creds() throws IOException {

		HomePage homePage = landingPage.login("nikhil.kharb@ymail.com", "Test@123");
		String message = homePage.getLoginMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Login Successfully"));

	}

	@Test
	public void logintest_002_valid_email_invalid_pass() throws IOException {

		HomePage homePage = landingPage.login("nikhil.kharb@ymail.com", "Test@12345");
		String message = homePage.getLoginMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Incorrect email or password."));

	}

	@Test
	public void logintest_003_invalid_email_valid_pass() throws IOException {

		HomePage homePage = landingPage.login("nikhil.kharb@yuiymail.com", "Test@123");
		String message = homePage.getLoginMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Incorrect email or password."));

	}

}
