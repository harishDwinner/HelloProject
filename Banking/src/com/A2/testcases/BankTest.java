package com.A2.testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseclass.BaseClassTest;

@Listeners(listeners.GeneralListeners.class)
public class BankTest extends BaseClassTest
{
	public Properties prop;
	public WebElement bankManagerLogin;
	
	
	@Test(priority=1)
	public void Banking() throws IOException, InterruptedException
	{
		log = extend.startTest("Banking Manager Info");
		
		//System.out.println("Hello");
		
		String bankManagerLog=getProperties().getProperty("BankManagerLogin");
		Thread.sleep(5000);
		log.log(LogStatus.INFO,"Bank Manager Option selected");
		bankManagerLogin=findElementByXpath(bankManagerLog);
		Thread.sleep(5000);
		bankManagerLogin.click();
		Thread.sleep(5000);
		
		extend.endTest(log);
		
	}
	
	@Test(priority=2,dataProvider = "dp")
	public void addCustomerDetails(String firstname,String lastName,String pincode) throws IOException, InterruptedException
	{
		
		log = extend.startTest("Adding customer details...!");
		
		System.out.println(firstname);
		System.out.println(lastName);
		System.out.println(pincode);
		log.log(LogStatus.INFO,"First Name LastName Pincode added");
		findElementByXpath(getProperties().getProperty("AddCustomer")).click();
		Thread.sleep(5000);
		
		findElementByXpath(getProperties().getProperty("FirstName")).sendKeys(firstname);
		Thread.sleep(5000);
		findElementByXpath(getProperties().getProperty("LastName")).sendKeys(lastName);
		Thread.sleep(5000);
		findElementByXpath(getProperties().getProperty("PostCode")).sendKeys(pincode);
		Thread.sleep(5000);
		findElementByXpath(getProperties().getProperty("Submit")).click();
		Thread.sleep(5000);
		handleAlertForAdding();
		
		extend.endTest(log);
		
	}
	
	
	@Test(priority=3)
	public void openAccount() throws InterruptedException, IOException
	{
		log = extend.startTest("Open Account customer details...!");
		WebElement customer;
		WebElement currency;
		
		Thread.sleep(5000);
		findElementByXpath(getProperties().getProperty("openAccount")).click();
		Thread.sleep(5000);
		customer=findElementById(getProperties().getProperty("customerId"));
		currency=findElementById(getProperties().getProperty("currencyId"));
		
				
		selectOptions(customer,"Ron");
		Thread.sleep(5000);
		selectOptions(currency,"Pound");
		log.log(LogStatus.PASS, "Open Account Deatils Added Successfully...!");
		extend.endTest(log);
		
	}

	
}