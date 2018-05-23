package baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class BaseClassTest {
	
	public static WebDriver driver;
	static Workbook wb=null;
	static FileInputStream fisExcel=null;
	static FileInputStream fisProperties=null;
	public static Properties propGeneral=null;
	public static Properties propertiesExternal=null;
	static String url=null;
	public static DataFormatter formatter= new DataFormatter();
	protected static short colCount=0;
	protected static int rowCount=0;
	static FileInputStream excelRead=null;
	static Alert al;
	
	public static ExtentReports extend;
	
	public static ExtentTest log;
	
	@BeforeSuite
	public void togetExtentResult()
	{
		extend = new ExtentReports("./test-output/adv.html");
		extend.loadConfig(new File("./extent-config.xml"));
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		propertiesExternal=getProperties();
		String browser=propertiesExternal.getProperty("browser");
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./ExecutableFiles//chromedriver.exe");
			driver = new ChromeDriver();
			openUrl();
			
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "./ExecutableFiles//geckodriver.exe");
			driver = new FirefoxDriver();
			openUrl();
		}
			
		
	}
	
	
	public void openUrl() throws IOException
	{
		propertiesExternal=getProperties();
		url=propertiesExternal.getProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
	}

	/*@BeforeMethod
	public void openBrowser()
	{
		driver.manage().window().maximize();
		driver.get(url); 
		
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.close();
	}*/
	
	@AfterClass
	public void quitBrowser() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.quit();
	}
	
	public String getExcelData(String sheet,int row,int column) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		fisExcel = new FileInputStream("./ExternalFiles//testData.xlsx");
		wb = WorkbookFactory.create(fisExcel);
		Cell cell= wb.getSheet(sheet).getRow(row).getCell(column);
		String value=formatter.formatCellValue(cell);
		return value;
	}

	public Properties getProperties() throws IOException
	{
		fisProperties =new FileInputStream("./ExternalFiles//OR.properties");
		propGeneral = new Properties();
		propGeneral.load(fisProperties);
		return propGeneral;
	}
	
	public WebElement findElementByXpath(String locator)
	{
		return driver.findElement(By.xpath(locator));
	}
	

	public WebElement findElementById(String locator)
	{
		return driver.findElement(By.id(locator));
	}
	
	public boolean isElementPresent(By expression)
	{
		try
		{
			driver.findElement(expression);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	
	
	public void getExcelCount(String excelPath,String sheetName) throws Exception
	{
		excelRead= new FileInputStream(excelPath);
		wb=WorkbookFactory.create(excelRead);
		Sheet sheet=wb.getSheet(sheetName);
		colCount=sheet.getRow(0).getLastCellNum();
		rowCount=sheet.getLastRowNum();
		
	}
	
	@DataProvider(name="dp")
	public Object[][] getExcelDetails() throws Exception, InvalidFormatException, IOException
	{
		String excelPath="./ExternalFiles//testData.xlsx";
		excelRead= new FileInputStream(excelPath);
		wb=WorkbookFactory.create(excelRead);
		Sheet sheet=wb.getSheet("Details");
	
		colCount=sheet.getRow(0).getLastCellNum();
		rowCount=sheet.getLastRowNum();
		
		System.out.println("Number of rows "+rowCount);
		System.out.println("Number of columns "+colCount);
		
		
		Object data[][]=new Object[rowCount][colCount];
		
		for(int row=1;row<=rowCount;row++)
		{
			for(int col=0;col<colCount;col++)
			{
				
				data[row-1][col]=getExcelData("Details", row, col);
			}
		}
		return data;
	}
	
	public void handleAlertForAdding()
	{
		al=driver.switchTo().alert();
		String alertData=al.getText();
		Assert.assertTrue(alertData.contains("success"));
		log.log(LogStatus.PASS, "Customer details successfully added");
		al.accept();
	}
	
	
	public void selectOptions(WebElement selectElement,String checkString)
	{
		Select select= new Select(selectElement);
		List<WebElement>allElements=select.getOptions();
		
		for(int i=0;i<allElements.size();i++)
		{
			String data=allElements.get(i).getText();
			System.out.println(data);
			if(data.contains(checkString))
			{
				select.selectByIndex(i);;
				break;
			}
		}
	}
	
	@AfterSuite
	public void configAS() {
	extend.flush();
	extend.close();
	}
}
