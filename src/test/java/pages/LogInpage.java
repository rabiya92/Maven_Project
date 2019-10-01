package pages;

import java.util.Hashtable;


import commonmethods.Commonmethod;
import testbase.TestBase;

public class LogInpage extends TestBase {
	public static void createAnAccount(Hashtable<String, String> testData) throws Exception {
		
		Commonmethod.clickOnWebElement("Xbtn","Click on tryforfree button");
		Commonmethod.sendkeys("XFName", testData.get("First_Name"), "First Name has been entered");
		Commonmethod.sendkeys("XLName", testData.get("Last_Name"), "Last Name has been entered");
		Commonmethod.sendkeys("Xemail", testData.get("Email_ID"), " Email_ID has been entered");
		Commonmethod.sendkeys("Xpnhno", testData.get("Phone_Numer"), "Phone_Numer has been entered");
		Commonmethod.sendkeys("Xcmpny", testData.get("company"), "company Name has been entered");
		Commonmethod.employees("Xemp" , testData.get("employees"));
		Commonmethod.Jobtitle("Xtitle" , testData.get("Jobtitle"));
		Commonmethod.country("Xcountry", testData.get("country"));
		
	}
}
	
	
		
