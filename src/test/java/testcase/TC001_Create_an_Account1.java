package testcase;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LogInpage;
import testbase.TestBase;

public class TC001_Create_an_Account1 extends TestBase {
	
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
