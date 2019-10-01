package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Master_Sheet.xlsx");
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Hashtable<String, String> testcaseRunmode = new Hashtable<String, String>();
	static String testcasename;


	@BeforeSuite
	
	public static void Loadingfiles() throws IOException {

	FileInputStream fis = new FileInputStream(
	System.getProperty("user.dir") + "\\src\\test\\resources\\properties_files\\config.properties");
	config.load(fis);

	FileInputStream fis1 = new FileInputStream(
	System.getProperty("user.dir") + "\\src\\test\\resources\\properties_files\\or.properties");
	OR.load(fis1);

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	extent = new ExtentReports(System.getProperty("user.dir") + "\\src\\test\\resources\\execution_reports\\abc_"
	+ timeStamp + ".html");
	loadhashtable(testcaseRunmode, "Test_Cases", "TestCaseName", "Run_Mode");
	}

	@BeforeMethod
	public static void LaunchingBrowser() {

	if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver",
	"C:\\Eclipse_Data\\Maven_Project\\src\\test\\resources\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	} else if (config.getProperty("Browser").equals("firefox")) {
	System.setProperty("webdriver.firefox.driver", "C:\\Users\\JAY GANESH\\Downloads\\firefox.exe");

	driver = new FirefoxDriver();
	}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15l, TimeUnit.SECONDS);
	test = extent.startTest(testcasename);
	driver.get(config.getProperty("url"));
	test.log(LogStatus.INFO, "Browser has been launched and redirected to url"+config.getProperty("url"));
	}

	@AfterMethod
	public void closebrowser() throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public static void writeIntoExtentReport() throws InterruptedException {
	extent.endTest(test);
	extent.flush();

	}

	public static void takescreenshots() throws IOException {

	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
	+ "\\src\\test\\resources\\screenShots\\screnshot_" + timeStamp + ".png";

	File destFile = new File(reportDirectory);

	org.openqa.selenium.io.FileHandler.copy(scrFile, destFile);

	test.log(LogStatus.PASS, test.addScreenCapture(reportDirectory));

	
	}

	public static void loadhashtable(Hashtable<String, String> testcaseRunmode, String sheetName, String keycol,
	String valuecol) {
	int row = excel.getRowCount(sheetName);
	for (int i = 2; i <= row; i++) {
	String key = excel.getCellData(sheetName, keycol, i);

	String val = excel.getCellData(sheetName, valuecol, i);
	testcaseRunmode.put(key, val);

	}
	System.out.println(testcaseRunmode);
	}

	public static boolean isexecutable(String Tc_Name) {
	testcasename = Tc_Name;
	if (testcaseRunmode.get(testcasename).equalsIgnoreCase("Y")) {
	return true;
	} else {
	return false;
	}
	}
	    public static void passlogstatus(String message) throws IOException{
	test.log(LogStatus.PASS, message);
	takescreenshots();

	}



	@DataProvider
	public static Object[][] Data_collection() {
	DataCollection dc = new DataCollection(excel, "Test_Data", testcasename);
	return dc.dataArray();
	}
	
}

