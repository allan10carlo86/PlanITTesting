package DataObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_CartPage{
	
	By checkoutButton = By.xpath("//a[contains(text(),'Check Out')]");
	By total_text = By.xpath("//strong[contains(text(),'Total:')]");

	public void validateCount(WebDriver driver, WebDriverWait wait, String product, int count) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkoutButton));
		By quantity_Textfield = By.xpath("//td[contains(text(), '"+ product +"')]/following-sibling::td[2]/input");
		String quantity_str = driver.findElement(quantity_Textfield).getAttribute("value");
		int value = Integer.parseInt(quantity_str);
		System.out.println("Value = " + value);
		System.out.println("Count = " + count);
		boolean bool = value == count;
		System.out.println(product + " Validation: ");
		if (bool) {
			System.out.println("Values are equal");
		} else {
			System.out.println("Values are NOT equal");
		}
		Assert.assertEquals(value,count);
	}
	
	public void validatePrice(WebDriver driver, WebDriverWait wait, String[] product, double[] price,double[] quantity, double total) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkoutButton));
		double total_sum = 0;
		System.out.println("----------------------------------------");
		System.out.println("Get into Loop");
		for(int i = 0; i < product.length; i++) {
			//Price 
			By price_Textfield = By.xpath("//td[contains(text(),'"+ product[i] +"')]/following-sibling::td[1]");
			String price_str = driver.findElement(price_Textfield).getAttribute("innerHTML");
			System.out.println(price_str);
			price_str = price_str.replace("$","");
			double price_double = Double.parseDouble(price_str);
			assertEqualsValidation(price[i], price_double, product[i]);

			//Quantity
			By quantity_Textfield = By.xpath("//td[contains(text(), '"+ product[i] +"')]/following-sibling::td[2]/input");
			String quantity_str = driver.findElement(quantity_Textfield).getAttribute("value");
			System.out.println(quantity_str);
			double quantity_double = Double.parseDouble(quantity_str);
			assertEqualsValidation(quantity[i], quantity_double, product[i]);
			System.out.println(product[i] + " Validation quantity: ");
	
			//Subtotal
			By subtotal_Textfield = By.xpath("//td[contains(text(), '"+ product[i] +"')]/following-sibling::td[3]");
			String subtotal_str = driver.findElement(subtotal_Textfield).getAttribute("innerHTML");
			System.out.println(subtotal_str);
			subtotal_str = subtotal_str.replace("$","");
			double subtotal_double = Double.parseDouble(subtotal_str);
			assertEqualsValidation(price_double*quantity_double,subtotal_double,product[i]);
			System.out.println("----------------------------------------");
			total_sum += price_double*quantity_double;
			
		}
		
		System.out.println("Total Sum is : " + total_sum);
		String total_str = driver.findElement(total_text).getText();
		String[] total_str_array = total_str.split(":");
		double total_double = Double.parseDouble(total_str_array[1].replace("\\s", ""));
		System.out.println("TOTAL Validation: ");
		System.out.println("total_str_array: " + total_str_array[1]);
		System.out.println("total_double: " + total_double);
		assertEqualsValidation(total_double, total_sum,"");

	}
	
	public void assertEqualsValidation(double expected, double actual, String product) {
		boolean bool = expected== actual;
		System.out.println( product +" Validation: ");
		if (bool) {
			System.out.println("Values are equal");
		} else {
			System.out.println("Values are NOT equal");
		}
		Assert.assertEquals(bool, bool);;
		
	}
	
	
}
