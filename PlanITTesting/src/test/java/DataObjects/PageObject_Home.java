package DataObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_Home{

	By contact_link = By.xpath("//a[text()='Contact']");
	By start_Shopping_Button = By.xpath("//a[contains(text(),'Start Shopping')]");
	
	
	public void clickContactLink(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contact_link));
		driver.findElement(contact_link).click();
		
	}
	
	public void clickStartShopping(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(start_Shopping_Button));
		driver.findElement(start_Shopping_Button).click();
	}
}
