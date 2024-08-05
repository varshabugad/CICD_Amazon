package Company1.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Company1.TestComponenets.BaseTest;
import Company1.pageObjects.ProductCatelogue;




public class ErrorValidationTest extends BaseTest  {
	@Test(groups= {"ErrorHandeling"})
	public void ValidateEmailErrorMsg() throws IOException
	{
		
	Assert.assertEquals(landingpage.getErrorMessage("773801w1erw"),"Invalid email address.");
	
	
	}
	
	@Test(groups= {"ErrorHandeling"})
	public void ValidateMobileErrorMsg() throws IOException
	{
		
	Assert.assertEquals(landingpage.getErrorMessage("7738013421162"),"Invalid mobile number");
	
	
	
}
}
