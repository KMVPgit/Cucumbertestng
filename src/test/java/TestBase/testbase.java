package TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import help.utilitieshelp;

public class testbase {
	
	
	public static WebDriver driver;
	public utilitieshelp up;
	public Properties prop;
//	pageB page;
//	public static Logger log;
	//Logger
	
	public testbase() throws IOException {
		prop = new Properties();
		FileInputStream is = new FileInputStream("C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\src\\test\\java\\help\\config.txt");
		prop.load(is);
		
	}
	
	
	//@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {
		
		//Initialize Logger object 
		
		//log =  LogManager.getLogger(testbase.class);
	//	BasicConfigurator.configure();  
		//Initialize prop object to read config file
		
		if (driver == null){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	page = new pageB(driver);
		driver.get("https://freecrm.co.in");	
		//log.info("Browser is opened with url");
		
		}			}		
	
	//Webdriver factory cucumber
	/*
	 * import org.openqa.selenium.WebDriver; import
	 * org.openqa.selenium.firefox.FirefoxDriver; import
	 * org.openqa.selenium.chrome.ChromeDriver;
	 * 
	 * public class WebDriverFactory { public static WebDriver createWebDriver() {
	 * String webdriver = System.getProperty("browser", "firefox");
	 * switch(webdriver) 
	 * { 
	 * case "firefox": 
	 * return new FirefoxDriver(); 
	 * case "chrome": 
	 * return new ChromeDriver(); 
	 * default: throw new
	 * RuntimeException("Unsupported webdriver: " + webdriver); } } }
	 */
	//*******************************************************************************************************
		/*
		 * @AfterMethod public void tearDown(ITestResult result) {
		 * if(ITestResult.FAILURE==result.getStatus()){ try{ // To create reference of
		 * TakesScreenshot TakesScreenshot screenshot=(TakesScreenshot)driver; // Call
		 * method to capture screenshot File
		 * src=screenshot.getScreenshotAs(OutputType.FILE); // Copy files to specific
		 * location // result.getName() will return name of test case so that screenshot
		 * name will be same as test case name FileUtils.copyFile(src, new
		 * File("C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\Screenshotsfailed"+
		 * result.getName()+".png")); // Scenario. embed(screenshot, "image/png");
		 * 
		 * System.out.println("Successfully captured a screenshot"); }catch (Exception
		 * e){ System.out.println("Exception while taking screenshot "+e.getMessage());
		 * } } }
		 */
	
	/*
	 * @AfterClass(alwaysRun = true) public void teardown() { driver.quit(); }
	 */

}

/*
 * System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
 * 
 * String downloads = new File("downloads").getAbsolutePath(); HashMap<String,
 * Object> chromePrefs = new HashMap<String, Object>();
 * chromePrefs.put("profile.default_content_settings.popups", 0);
 * chromePrefs.put("download.default_directory", downloads);
 * chromePrefs.put("download.prompt_for_download", false);
 * chromePrefs.put("download.directory_upgrade", true);
 * 
 * ChromeOptions options = new ChromeOptions();
 * options.setExperimentalOption("prefs", chromePrefs);
 * options.addArguments("enable-automation");
 * options.addArguments("start-maximized");
 * options.addArguments("disable-popup-blocking");
 * options.addArguments("disable-default-apps");
 * //options.addArguments("--no-sandbox");
 * options.addArguments("ignore-certificate-errors");
 * 
 * LoggingPreferences logPrefs = new LoggingPreferences();
 * logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
 * 
 * options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
 * options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
 * 
 * driver = new ChromeDriver(options);
 */


