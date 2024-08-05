package Company1.Tests;

import java.io.File;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Company1.TestComponenets.BaseTest;
import Company1.TestComponenets.Retry;
import Company1.pageObjects.CartPage;
import Company1.pageObjects.LandingPage;
import Company1.pageObjects.ProductCatelogue;
import Company1.pageObjects.checkoutPage;
import Company1.pageObjects.confirmationPage;

public class SubmitOrderTest extends BaseTest  {
	@Test(dataProvider= "getData",groups= {"purchase"},retryAnalyzer=Retry.class)
	public void submitOrder(String email,String password,String productName) throws IOException
	{
	String iteam ="Pluckk Ozone wash Tomato Hybrid, 500 Gm";	
	ProductCatelogue productCatelogue=landingpage.login(email, password);
	productCatelogue.addProductToCart(iteam);
	CartPage cartpage =productCatelogue.goToCartPage();
	Boolean match=cartpage.VerifyProductDisplay(productName);
	Assert.assertTrue(match);
	checkoutPage chechoutpage=cartpage.goTocheckOut();
	confirmationPage cp=chechoutpage.submitOrder();
	String msg= cp.verifyConfirmationMessage();
	System.out.println(msg); 
	Assert.assertEquals(msg, "Checkout");
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"7738011162", "Varsha#1","Pluckk Fresh Premium Bhendi, 500g"},{"7738011162", "Varsha#1","Fresh Onion, 1kg"}};
	}

}
