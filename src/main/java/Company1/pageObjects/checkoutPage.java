package Company1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import Company1.AbstractComponenets.AbstractComponent;

public class checkoutPage  extends AbstractComponent{
	
	WebDriver driver;
	public checkoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	//	PageFactory.initElements(driver,this);
	} 
	
	//@FindBy(xpath="//div/h1[@class='a-color-base']")
//	WebElement needAnythingElse;
public confirmationPage submitOrder()
{
	//waitforvisibilityOf(needAnythingElse);
	//driver.findElement(RelativeLocator.with(By.xpath("//a[@name='proceedToCheckout']")).toRightOf(driver.findElement(By.xpath("//div/h1[contains(.,'Need anything else?')]"))).click();
	
	WebElement element=driver.findElement(By.xpath("//div/h1[contains(.,'Need anything else?')]"));
	driver.findElement(RelativeLocator.with(By.xpath("//a[@name='proceedToCheckout']")).toRightOf(element)).click();

	return new confirmationPage(driver);
}

}

	

