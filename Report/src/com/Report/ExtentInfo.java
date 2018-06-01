package com.Report;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentInfo {

	ExtentReports extend;
	ExtentTest logger;

	@BeforeSuite
	public void config() {
		extend = new ExtentReports("./test-output/adv.html");
		extend.loadConfig(new File("./extent-config.xml"));
	}

	@Test
	public void createOrderTest() 
	{
		ExtentTest log = extend.startTest("createOrderTest");
		log.log(LogStatus.INFO, "Login to App");
		log.log(LogStatus.INFO, "Navigate order Page");
		log.log(LogStatus.INFO, "Create Order");
		log.log(LogStatus.INFO, "Verify Order");
		if ("123".equals("123")) {
			log.log(LogStatus.PASS, "Verify order");
		} else {
			log.log(LogStatus.FAIL, "Verify Order");
		}
		extend.endTest(log);
	}
	@AfterSuite
	public void configAS() {
	extend.flush();
	extend.close();
	}

}
