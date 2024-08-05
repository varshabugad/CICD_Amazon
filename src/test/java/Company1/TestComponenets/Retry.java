package Company1.TestComponenets;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count=0;
		int maxrun=1;
		if(count<maxrun)
		{
			count++;
			return true;
			
		}
				
				
				return false;
	}

}
