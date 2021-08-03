package testNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerTest implements IRetryAnalyzer {
	int limit=3;
	int counter=0;
	
	
public boolean retry(ITestResult result){
	if(!result.isSuccess()) {
		if(counter<limit) {
			counter++;
			return true;
		}
	}
	return false;

  }
}
