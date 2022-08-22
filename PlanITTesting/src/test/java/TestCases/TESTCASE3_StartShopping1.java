package TestCases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataObjects.PageObject_CartPage;
import DataObjects.PageObject_Home;
import DataObjects.PageObject_SelectionPage;
import DataObjects.WebDriverClass;

public class TESTCASE3_StartShopping1 extends WebDriverClass{

	WebDriver driver;
	WebDriverWait wait;
	PageObject_Home homePage;
	PageObject_SelectionPage selectionPage;
	PageObject_CartPage cartPage;
	
	@Before
	public void before() throws IOException {
		this.driver = super.initializeWebDriver(this.driver);
		this.wait = super.initializeWebDriverWait(this.driver);
		super.openWindow(this.driver, super.getValueFromExcel("01_URL", "URL", "login"));
		homePage = new PageObject_Home();
		selectionPage = new PageObject_SelectionPage();
		cartPage = new PageObject_CartPage();
	}
	
	@Test
	public void main() throws InterruptedException, IOException {
		homePage.clickStartShopping(this.driver, this.wait);		
		selectionPage.clickBuy(this.driver,this.wait,4);
		selectionPage.clickBuy(this.driver,this.wait,6);
		selectionPage.clickBuy(this.driver,this.wait,6);
		selectionPage.clickCartLink(this.driver, this.wait);
		cartPage.validateCount(this.driver, this.wait, "Fluffy Bunny", 1);
		cartPage.validateCount(this.driver, this.wait, "Funny Cow", 2);

	}
	
	@After
	public void close() throws InterruptedException 
	{
		super.closeWindow(this.driver);
	}
}

