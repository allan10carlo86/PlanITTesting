package DataObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class PageObject_ContactPage{

	By submit_button = By.xpath("//a[text()='Submit']");
	By forename_error_text = By.id("forename-err");
	By email_error_text = By.id("email-err");
	By message_error_text = By.id("message-err");
	By forename_textfield= By.id("forename");
	By email_textfield = By.id("email");
	By message_textfield = By.id("message");
	String str_textFromError = null;

	public void validateContactPage(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(submit_button));
	}
	
	public void clickSubmitButton(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(submit_button));
		driver.findElement(submit_button).click();
	}
	
	public void validateErrorMessages(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(forename_error_text));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(email_error_text));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message_error_text));
	}
	
	public void filloutFieldsInContact(WebDriver driver, WebDriverWait wait ,
			String str_forename, String str_email, String str_message) {
		driver.findElement(forename_textfield).sendKeys(str_forename);
		driver.findElement(email_textfield).sendKeys(str_email);
		driver.findElement(message_textfield).sendKeys(str_message);
	}
	
	public void validateIfErrorsAreGone(WebDriver driver, WebDriverWait wait ) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(forename_error_text));	
		isVisibile(driver, forename_error_text);
		this.str_textFromError = null;
		wait.until(ExpectedConditions.invisibilityOfElementLocated(email_error_text));
		isVisibile(driver, email_error_text);
		this.str_textFromError = null;
		wait.until(ExpectedConditions.invisibilityOfElementLocated(message_error_text));
		isVisibile(driver, message_error_text);

	}
	
	public void isVisibile(WebDriver driver, By element) {
		try {
			this.str_textFromError = driver.findElement(element).getText();
			System.out.println("Text from isVisible " + this.str_textFromError);
			
		} catch (Exception e) {
			System.out.println(this.str_textFromError);
			System.out.println("is Null");
			Assert.assertEquals(this.str_textFromError, null);
		}
	}
	
	public void validateMessage(WebDriver driver, WebDriverWait wait, String str_forename) {
		By messageBy = By.xpath("//strong[contains(text(),'Thanks "+ str_forename+ "')]");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(messageBy));
		String str_FromWebElement = driver.findElement(messageBy).getText();
		System.out.println("Validation is : " + str_FromWebElement);
		Assert.assertEquals(str_FromWebElement,"Thanks "+str_forename);
	}
	
}
