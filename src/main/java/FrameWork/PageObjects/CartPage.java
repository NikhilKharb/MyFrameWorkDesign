package FrameWork.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWork.AbstractComponents.AbstractClass;

public class CartPage extends AbstractClass {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	WebElement prodName;

	@FindBy(css = ".subtotal ul li button")
	WebElement checkoutBtn;

	public String verifyProd() {
		String actname = prodName.getText();

		return actname;
	}

	public CheckOutPage checkOut() {
		checkoutBtn.click();
		CheckOutPage chkoutPage = new CheckOutPage(driver);
		return chkoutPage;
	}

}
