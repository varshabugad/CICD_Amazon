package Company1.AbstractComponenets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Company1.pageObjects.CartPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);

}
	@FindBy(xpath="//span[@id='nav-cart-count']")
	WebElement waitCartButton;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	WebElement cartButton;
	
	@FindBy(xpath="//a[@id='a-autoid-0-announce']")
	WebElement goToFreshCart;
	
	public void waitforvisibilityOf(By waitProducts2) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitProducts2));	
	}
	public void waitforvisibilityOf(WebElement element)
	{
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitElementToBeClickable(WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void waitforvisibilityOflist(List<WebElement> waitProducts2) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(waitProducts2));	}
	

	public CartPage goToCartPage()
	{
		waitElementToBeClickable(waitCartButton);
		cartButton.click();
		goToFreshCart.click();
		CartPage cartpage =new CartPage(driver);
		return cartpage;
	}
	
}
