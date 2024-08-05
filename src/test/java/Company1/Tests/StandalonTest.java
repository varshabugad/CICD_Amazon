package Company1.Tests;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Company1.pageObjects.LandingPage;

public class StandalonTest {
	public static void main(String[] args) {
	
		String iteam ="Pluckk Fresh Ozone Washed Ginger (Adrak), 200g";
		ChromeOptions option=new ChromeOptions();
	option.addArguments("start-maximized");
	WebDriver driver =new ChromeDriver(option);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in");
	//driver.manage().window().maximize();
	//explicit wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
	Actions action = new Actions(driver);
	//login
	action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).perform();
	driver.findElement(By.className("nav-action-inner")).click();
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='ap_email_login']"))));
	driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys("7738011162");
	driver.findElement(By.className("a-button-input")).click();
	driver.findElement(By.id("ap_password")).sendKeys("Varsha#1");
	driver.findElement(By.id("signInSubmit")).click();
	
	
	//add to cart
	action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-groceries']"))).perform();
	//driver.findElement(By.cssSelector(".f3-cgi-flyout-store-box.f3-cgi-flyout-store-box-left")).click();
	driver.findElement(By.xpath("//div[@class='f3-cgi-flyout-store-box f3-cgi-flyout-store-box-left']")).click();
	driver.findElement(By.xpath("//img[@src='https://images-eu.ssl-images-amazon.com/images/G/31/img24/July/SF/SBC/Fruits__vegetables.jpg']")).click();
	driver.findElement(By.xpath("//img[@src='https://images-eu.ssl-images-amazon.com/images/G/31/img18/Fresh/Feb24/All_vegetables.jpg']")).click();
	//List<WebElement> products = driver.findElements(By.cssSelector(".sg-col-4-of-12"));
	List<WebElement> products = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']"));
	products.forEach(temp->System.out.println(temp.getText()));
	
	WebElement prod =products.stream().filter(temp->temp.findElement(By.xpath("//h2/a/span")).getText().equals(iteam)).findFirst().orElse(null);
	prod.findElement(By.className("a-button-input")).click();	
	//wait
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@id='nav-cart-count']"))));
	//go to cart
	driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
	driver.findElement(By.xpath("//a[@id='a-autoid-0-announce']")).click();
	List<WebElement> cartProducts = driver.findElements(By.xpath("//span/a/span/span"));
	Boolean match = cartProducts.stream().anyMatch(temp->temp.getText().equals(iteam));
	cartProducts.forEach(temp->System.out.println("Found items -"+temp.getText()));
	//System.out.println(foundCartItem.findElement(By.xpath("//span[@class='a-list-item']/a/span/span/span[@class='a-truncate-full a-offscreen']")).getText());
	Assert.assertTrue(match);
	driver.findElement(By.xpath("//input[@name='proceedToALMCheckout-ctnow']")).click();
	WebElement element=driver.findElement(By.xpath("//div/h1[contains(.,'Need anything else?')]"));
	
	driver.findElement(RelativeLocator.with(By.xpath("//a[@name='proceedToCheckout']")).toRightOf(element)).click();
	String msg= driver.findElement(By.tagName("h1")).getText();
	System.out.println(msg); 
	Assert.assertEquals(msg, "Checkout");
	}
	

}
