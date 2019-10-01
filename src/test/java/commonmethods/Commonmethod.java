package commonmethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import testbase.TestBase;

public class Commonmethod  extends TestBase{
	

		public static void clickOnWebElement(String xpath, String webelement) throws Exception {
			try
			{
			driver.findElement(By.xpath(OR.getProperty(xpath))).click();
			test.log(LogStatus.PASS, webelement + "has been clicked");
			TestBase.takescreenshots();
			Reporter.log(webelement + "has been clicked");
			}
			catch (Throwable t) {
				
				test.log(LogStatus.FAIL, "Unable to click:-" + webelement + "because of:-" + t.getMessage());
				TestBase.takescreenshots();
		
	}
		}
			
		public static void sendkeys(String xpath,String Data,String webelement) throws IOException{
			try
			{
			driver.findElement(By.xpath(OR.getProperty("xpath"))).sendKeys(Data);
	    	Reporter.log(webelement+ "has been entered");
			}
	    	catch (Throwable t){
	    	test.log(LogStatus.PASS, "email id has been entered");
	    	TestBase.takescreenshots();
		}
		}
		
		public static void Jobtitle (String xpath, String webelement) throws Exception {
			try{
				
			Select s=new Select(driver.findElement(By.xpath(OR.getProperty(xpath))));
			s.selectByValue("IT Manager");
			test.log(LogStatus.PASS, webelement + " has been selected");
			TestBase.takescreenshots();
			Reporter.log(webelement + " has been selected");
			}
			catch(Throwable t) {
				
				test.log(LogStatus.FAIL, "Unable to select year:-" + webelement + "because of:-" + t.getMessage());
				TestBase.takescreenshots();
			}
		}
		
		

public static void employees (String xpath, String webelement) throws Exception {
	try{
	Select s=new Select(driver.findElement(By.xpath(OR.getProperty(xpath))));
	s.selectByIndex(1);
	test.log(LogStatus.PASS, webelement + " has been selected");
	TestBase.takescreenshots();
	Reporter.log(webelement + " has been selected");
	}
	catch(Throwable t) {
		
		test.log(LogStatus.FAIL, "Unable to select year:-" + webelement + "because of:-" + t.getMessage());
		TestBase.takescreenshots();
	}
}
	
public static void country (String xpath, String webelement) throws Exception {
	try{
	Select s=new Select(driver.findElement(By.xpath(OR.getProperty(xpath))));
	s.selectByValue("uk");
	test.log(LogStatus.PASS, webelement + " has been selected");
	TestBase.takescreenshots();
	Reporter.log(webelement + " has been selected");
	}
	catch(Throwable t) {
		
		test.log(LogStatus.FAIL, "Unable to select year:-" + webelement + "because of:-" + t.getMessage());
		TestBase.takescreenshots();
		
		
	}
	}}

	
