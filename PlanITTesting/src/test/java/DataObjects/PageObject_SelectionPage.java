package DataObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_SelectionPage{
	
	By cart_link = By.xpath("//a[@href='#/cart']");
	
	public void clickBuy(WebDriver driver, WebDriverWait wait, int index) throws InterruptedException {
		By buyButton = By.xpath("(//a[text()='Buy'])["+ Integer.toString(index)+"]");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(buyButton));
		driver.findElement(buyButton).click();
	}
	
	public void clickCartLink(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cart_link));
		driver.findElement(cart_link).click();
	}
}
