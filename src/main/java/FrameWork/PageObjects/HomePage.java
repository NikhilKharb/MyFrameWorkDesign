package FrameWork.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWork.AbstractComponents.AbstractClass;

public class HomePage extends AbstractClass {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By toastMessage = By.cssSelector("#toast-container");
	By loader = By.cssSelector(".ng-animating");

	@FindBy(css = "#toast-container")
	WebElement message;

	@FindBy(xpath = "(//button[@class='btn btn-custom'])[4]")
	WebElement logOutBtn;

	@FindBy(css = ".mb-3")
	List<WebElement> prods;

	public void logOut() {
		logOutBtn.click();
	}

	public String getLoginMessage() {
		waitElementVisibility(toastMessage);
		String fmessage = message.getText();
		waitElementInvisibility(toastMessage);
		return fmessage;
	}

	public List<WebElement> getProds() {
		return prods;
	}

	public WebElement getProdsByName(String name) {
		WebElement product = prods.stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().contains(name)).findFirst()
				.orElse(null);
		return product;
	}

	public String addToCart(String prodName) {
		WebElement product = getProdsByName(prodName);
		product.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		waitElementVisibility(toastMessage);
		return message.getText();

	}

}
