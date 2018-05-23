package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseclass.BaseClassTest;

public class GeneralListeners implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String name=result.getMethod().getMethodName();
		System.out.println("Failed method Method name is "+name);
		
		EventFiringWebDriver efw = new EventFiringWebDriver(BaseClassTest.driver);
		File src=efw.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\hp\\Desktop\\JANA\\Failure.jpg");
	//	File dest=new File("C:\\Users\\hp\\eclipse-workspace\\DataDrivenProjects\\Images\\failure2.jpg");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0)
	{
		// TODO Auto-generated method stub
		
	}


}
