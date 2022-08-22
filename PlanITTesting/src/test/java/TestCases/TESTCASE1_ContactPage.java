package TestCases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataObjects.PageObject_ContactPage;
import DataObjects.PageObject_Home;
import DataObjects.WebDriverClass;

public class TESTCASE1_ContactPage extends WebDriverClass{

	WebDriver driver;
	WebDriverWait wait;
	PageObject_Home homePage;
	PageObject_ContactPage contact_Page;
	
	@Before
	public void before() throws IOException {
		this.driver = super.initializeWebDriver(this.driver);
		this.wait = super.initializeWebDriverWait(this.driver);
		super.openWindow(this.driver, super.getValueFromExcel("01_URL", "URL", "login"));
		homePage = new PageObject_Home();
		contact_Page = new PageObject_ContactPage();
	}
	
	@Test
	public void main() throws InterruptedException, IOException {
		homePage.clickContactLink(this.driver, this.wait);
		contact_Page.validateContactPage(this.driver, this.wait);
		contact_Page.clickSubmitButton(this.driver, this.wait);
		contact_Page.validateErrorMessages(this.driver, this.wait);
		String contact_Forname_str = super.getValueFromExcel("02_CONTACT", "Value", "contact_forname");
		String contact_email_str = super.getValueFromExcel("02_CONTACT", "Value", "contact_email");
		String contact_message_str = super.getValueFromExcel("02_CONTACT", "Value", "contact_message");
		contact_Page.filloutFieldsInContact(this.driver, this.wait, contact_Forname_str, contact_email_str, contact_message_str);
		contact_Page.validateIfErrorsAreGone(this.driver, this.wait);
		
	}
	
	@After
	public void close() 
	{
		super.closeWindow(this.driver);
	}
}

