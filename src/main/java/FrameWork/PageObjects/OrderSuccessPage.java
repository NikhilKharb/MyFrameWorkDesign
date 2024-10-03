package FrameWork.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWork.AbstractComponents.AbstractClass;

public class OrderSuccessPage extends AbstractClass {

	WebDriver driver;

	public OrderSuccessPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By toastMessage = By.cssSelector("#toast-container");

	@FindBy(css = "#toast-container")
	WebElement message;

	@FindBy(css = ".hero-primary")
	WebElement successMessage;

	public String getSUccessMessage() {
		String message = successMessage.getText();
		return message;
	}

	public String getToastMessage() {
		waitElementVisibility(toastMessage);
		String fmessage=message.getText();
		waitElementInvisibility(toastMessage);
		return fmessage;
	}

}
