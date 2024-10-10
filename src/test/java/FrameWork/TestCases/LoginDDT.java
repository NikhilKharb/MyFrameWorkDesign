package FrameWork.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWork.PageObjects.HomePage;
import FrameWork.TestComponents.BaseTest;
import FrameWork.TestComponents.DataProviders;
import FrameWork.TestComponents.Retry;

public class LoginDDT extends BaseTest {

	@Test(groups = { "negative" }, retryAnalyzer = Retry.class, dataProvider = "LoginData",dataProviderClass=DataProviders.class)
	public void logintest_002_valid_email_invalid_pass(String order, String email, String pass, String msg) throws IOException {
		HomePage homePage = landingPage.login(email, pass);
		String message = homePage.getLoginMessage();
		Assert.assertEquals(message, msg);
	}
}
