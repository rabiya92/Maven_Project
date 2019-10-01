package testcase;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import pages.LogInpage;
import testbase.TestBase;

public class TC001_Create_an_Account  extends TestBase{
	
	@BeforeClass
	public static void isskip(){
		if(!isexecutable("TC001_Create_an_Account"))
			throw new SkipException("skipped testcases which has runmode set to  N");
	}
	
    @Test(dataProvider="Data_collection")
	public static void TC001_Create_an_Account(Hashtable<String,String>htdata) throws Exception{
    	
    	test = extent.startTest("TC001_Create_an_Account");
    	
    	
    	LogInpage.createAnAccount(htdata);
    
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	


    	
    	
    	
    	
		}
	

}