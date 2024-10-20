package FrameWork.TestCases;

import FrameWork.PageObjects.HomePage;
import FrameWork.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {

    @Test
    public void Test(){
        HomePage homePage = landingPage.login("nikhil.kharb@ymail.com", "Test@123");
	String message = homePage.getLoginMessage();
	Assert.assertTrue(message.equalsIgnoreCase("Login Successfully"));
	homePage.logOut();
    }
}
