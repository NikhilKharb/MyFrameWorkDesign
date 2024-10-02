package FrameWork.TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UntouchClass {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");

		driver.findElement(By.id("userEmail")).sendKeys("nikhil.kharb@ymail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.cssSelector(".login-btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		String smessage = driver.findElement(By.cssSelector("#toast-container")).getText();
		System.out.println(smessage);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));

		List<WebElement> prods = driver.findElements(By.cssSelector(".mb-3"));

//		for (WebElement prod : prods) {
//
//			if (prod.getText().contains("ZARA")) {
//				prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
//			}
//
//		}
		// same using streams

		WebElement product = prods.stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().contains("ZARA")).findFirst()
				.orElse(null);
		product.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		String addcartmessage = driver.findElement(By.cssSelector(".toast-container")).getText();
		System.out.println(addcartmessage);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		String prodcart = driver.findElement(By.cssSelector(".cartSection h3")).getText();
		System.out.println(prodcart);
		Assert.assertEquals(prodcart, "ZARA COAT 3");

		driver.findElement(By.cssSelector(".subtotal ul li button")).click();

		// driver.findElement(By.xpath("//input[@placeholder='Select
		// Country']")).sendKeys("Ind");
		// performing the same action using actions class using mouse actions.
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "Ind").build().perform();

		List<WebElement> countries = driver.findElements(By.cssSelector("section button span"));

		countries.stream().filter(countri -> countri.getText().equalsIgnoreCase("India")).findFirst().orElse(null)
				.click();

		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();

		String message =driver.findElement(By.cssSelector(".hero-primary")).getText();
System.out.println(message);
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();
	}

}
