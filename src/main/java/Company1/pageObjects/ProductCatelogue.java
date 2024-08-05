package Company1.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Company1.AbstractComponenets.AbstractComponent;

public class ProductCatelogue extends AbstractComponent {
	WebDriver driver;
	public ProductCatelogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//a[@id='nav-link-groceries']")
	WebElement mouseHoverFresh;
	
	@FindBy(xpath="//div[@class='f3-cgi-flyout-store-box f3-cgi-flyout-store-box-left']")
	WebElement clickFresh;
	
	@FindBy(xpath="//img[@src='https://images-eu.ssl-images-amazon.com/images/G/31/img24/July/SF/SBC/Fruits__vegetables.jpg']")
	WebElement clickFruitVeg;
	
	@FindBy(xpath="//img[@src='https://images-eu.ssl-images-amazon.com/images/G/31/img18/Fresh/Feb24/All_vegetables.jpg']")
	WebElement clickAllVeg;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']")
	List<WebElement> products;
	
	
//	@FindBy(xpath="//div[@class='a-section a-spacing-base']")
	//List<WebElement> products;
	
	
	
	@FindBy(xpath="//h2/a/span")
	List<WebElement> waitprodIteam;
	
	@FindBy(className="a-button-input")
	WebElement waitaddToCartButton;
	
	By addToCartButton =By.className("a-button-input");
	By waitProducts = By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']");
	By waitclickFresh= By.xpath("//div[@class='f3-cgi-flyout-store-box f3-cgi-flyout-store-box-left']");
	//By waitprodIteam=By.xpath("//h2/a/span");
	
	public List<WebElement> getProductList()
	{
		waitforvisibilityOflist(products);

		System.out.println(products.size())	;
		products.forEach(temp->System.out.println("Inproduct catelogue"+temp.getText()));
		return products;
	}

	

	public WebElement getProductByName(String iteam)
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(mouseHoverFresh).perform();
		//waitforvisibilityOf(waitclickFresh);
		waitElementToBeClickable(clickFresh);
		clickFresh.click();
		clickFruitVeg.click();
		clickAllVeg.click();
		System.out.println("in getProductByName " + iteam);
		/*for(int i=0;i<products.size();i++)
		{
			System.out.println("Products in for loop - "+products.get(i).findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText());
		}*/
		products.forEach(temp->System.out.println("prod -"+temp.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText()));
		waitforvisibilityOflist(waitprodIteam);
		
		WebElement prod =getProductList().stream().filter(temp->temp.findElement(By.xpath("//h2/a/span")).getText().equals(iteam)).findFirst().orElse(null);
		return prod;
	}
	


	public void addProductToCart(String item)
	{
		WebElement prod=getProductByName(item);
		System.out.println("in addtocart " + item);
		// 9waitforvisibilityOf(addToCartButton);
		waitElementToBeClickable(waitaddToCartButton);
		prod.findElement(addToCartButton).click();
		
	}
	
	
}
