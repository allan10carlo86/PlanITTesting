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

public class TESTCASE4_StartShopping2 extends WebDriverClass{

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
		
		//Click Stuffed Frog
		selectionPage.clickBuy(this.driver,this.wait,2);
		selectionPage.clickBuy(this.driver,this.wait,2);
		
		//Click Fluffy Bunny
		selectionPage.clickBuy(this.driver,this.wait,4);
		selectionPage.clickBuy(this.driver,this.wait,4);
		selectionPage.clickBuy(this.driver,this.wait,4);
		selectionPage.clickBuy(this.driver,this.wait,4);
		
		//Click Valentine Bear
		selectionPage.clickBuy(this.driver,this.wait,7);
		selectionPage.clickBuy(this.driver,this.wait,7);
		selectionPage.clickBuy(this.driver,this.wait,7);
		
		selectionPage.clickCartLink(this.driver, this.wait);
		
		///Needed more codes on this
		String[] product = new String[] {
				"Stuffed Frog",
				"Fluffy Bunny",
				"Valentine Bear"	
		};
		double[] price = new double[] {
				10.99,
				9.99,
				14.99
		};	
		double[] quantity = new double[] {
				2,
				4,
				3
		};	
		double total = 106.91;
		cartPage.validatePrice(this.driver, this.wait ,product,price,quantity,total);

	}
	
	@After
	public void close() throws InterruptedException 
	{
		super.closeWindow(this.driver);
	}
}

