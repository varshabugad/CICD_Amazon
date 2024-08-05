package Company1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Company1.AbstractComponenets.AbstractComponent;

public class confirmationPage extends AbstractComponent {
	WebDriver driver;
	public confirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	} 
	@FindBy(tagName="h1")
	WebElement msg;		

	public String verifyConfirmationMessage()
	{
		return msg.getText();
		
	}
}
