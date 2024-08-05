package Company1.TestComponenets;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import Company1.pageObjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingpage;

	public WebDriver InitializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Company1//Resources//GolbalData.properties");
		prop.load(fis);
		String browserName =	System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("Browser");
	//	String browserName = prop.getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		//ChromeOptions option=new ChromeOptions();
		
		//option.addArguments("start-maximized");
		
			driver =new ChromeDriver();
				
			}
		else if(browserName.equalsIgnoreCase("edge"))
		{


			 driver =new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver=	InitializeDriver();
		 landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	public String getScreenShot(String testcasename,WebDriver driver ) throws IOException
	{
		TakesScreenshot ts=	(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
	}
}
