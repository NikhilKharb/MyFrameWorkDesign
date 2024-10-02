package FrameWork.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWork.AbstractComponents.AbstractClass;

public class CheckOutPage extends AbstractClass {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryField;

	@FindBy(css = "section button span")
	List<WebElement> countries;

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement placeOrderBtn;

	public void enterCountry(String initials) {
		countryField.sendKeys(initials);
	}

	public void selectCountry(String countryName) {
		countries.stream().filter(countri -> countri.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null)
				.click();
	}

	public OrderSuccessPage placeOrder() {
		placeOrderBtn.click();
		OrderSuccessPage cnfordrPage = new OrderSuccessPage(driver);
		return cnfordrPage;
	}

}
