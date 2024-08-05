package Company1.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Company1.AbstractComponenets.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	

	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement mouseHoverSignIn1;
	
	@FindBy(className="nav-action-inner")
	WebElement mouseHoverSignIn2;
	
	@FindBy(xpath="//*[@id='ap_email_login']")
	WebElement username;
	
	@FindBy(className="a-button-input")
	WebElement inputButton;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement submit;
	
	@FindBy(xpath="//div[contains(text(),'Invalid email address.')]")
	WebElement InvalidEmail;


	@FindBy(xpath="//div[contains(text(),'Invalid mobile number')]")
	WebElement InvalidMobNumber;
	
	//By waitusername=By.xpath("//*[@id='ap_email_login']");
	By waitusername=By.name("email");
	public String getErrorMessage(String uname)
	{
		uname.chars().allMatch(c->c>='0' && c<='9');
		
		Actions action=new Actions(driver);
		action.moveToElement(mouseHoverSignIn1).perform();
		mouseHoverSignIn2.click();
		
		//waitElementToBeClickable(username);
		waitforvisibilityOf(waitusername);
		username.sendKeys(uname);
		inputButton.click();
		if(uname.chars().allMatch(c->c>='0' && c<='9'))
		{	
			waitforvisibilityOf(InvalidMobNumber);
			System.out.println("mob - "+InvalidMobNumber.getText());
			return InvalidMobNumber.getText();}
		else
			return InvalidEmail.getText();
	}

	
	public ProductCatelogue login(String uname,String pwd)
	{
		Actions action=new Actions(driver);
		action.moveToElement(mouseHoverSignIn1).perform();
		mouseHoverSignIn2.click();
		//waitElementToBeClickable(username);
		//waitforvisibilityOf(waitusername);
		username.sendKeys(uname);
		inputButton.click();
		waitforvisibilityOf(password);
		password.sendKeys(pwd);
		submit.click();
		ProductCatelogue productCatelogue=new ProductCatelogue(driver);
		return productCatelogue;

	}
	
	public void goTo()
	{
		driver.get("https://www.amazon.in");

	}
}
