package Company1.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import Company1.AbstractComponenets.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span/a/span/span")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//input[@name='proceedToALMCheckout-ctnow']")
	WebElement checkout;
	
	@FindBy(xpath="//div/h1[contains(.,'Need anything else?')]")
	WebElement needAnythingElse;
	
	@FindBy(xpath="//a[@name='proceedToCheckout']")
	WebElement proceedToCheckout;

	public Boolean VerifyProductDisplay(String iteam)
	{
		Boolean match = cartProducts.stream().anyMatch(temp->temp.getText().equals(iteam));
		cartProducts.forEach(temp->System.out.println("Found items -"+temp.getText()));

		return match;
	
	}
	public checkoutPage goTocheckOut()
	{
		checkout.click();
		//driver.findElement(RelativeLocator.with(By.xpath("//a[@name='proceedToCheckout']")).toRightOf(needAnythingElse)).click();
		return new checkoutPage(driver);
	}
}
