package FrameWork.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWork.AbstractComponents.AbstractClass;

public class LandingPage extends AbstractClass {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(css = ".login-btn")
	WebElement loginButton;

	public HomePage login(String email,String pass) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		loginButton.click();
		HomePage homePage = new HomePage(driver);
		return homePage;
	}

	public void goToLoginPage() {
		driver.get("https://rahulshettyacademy.com/client/");

	}

}
