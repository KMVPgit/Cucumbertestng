package TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;

import org.openqa.selenium.chrome.ChromeDriver;
import help.utilitieshelp;
import jdk.internal.jline.internal.Log;
import tContext.testContext;

public class WebDriverManager {
	
	
	public static WebDriver driver;
	// public static String driverType;
	 
	  utilitieshelp up;
	  static Logger log;
	  
	  public static Properties prop;
		BufferedReader reader  ;
		FileReader filereader;
		
		public WebDriverManager(String path)  {
		/* prop = new Properties();
		 FileInputStream fi = null;	
			fi = new FileInputStream(path);
			prop.load(fi);	*/
			
					 try {
			 filereader	= new 	FileReader(path);  
			 reader = new BufferedReader(filereader);
			 prop = new Properties();
			 try {
			 prop.load(reader);
			 reader.close();
			 } catch (IOException e) {
			 e.printStackTrace();
			 }
			 } catch (FileNotFoundException e) {
			 e.printStackTrace();
			 throw new RuntimeException("Configuration.properties not found at " + path);
			 } 
			
			
		}

	    public WebDriver getDriver() throws Exception {
		 if(driver == null) 
			 {
			 driver = createWebDriver();			 
		// driver = new ChromeDriver();
	     	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        driver.get(prop.getProperty("baseurl"));
			 }
		 return driver;
		 }	  
		 
   public static WebDriver createWebDriver() throws Exception {
	  String webdriver = prop.getProperty("browser");
	 // log.info("browser = " + webdriver);
	 switch(webdriver) 
	 { 
	 case "firefox": 
		 return new FirefoxDriver(); 
		 
	case "chrome": 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\chromedriver_win32\\chromedriver.exe");
     	 return new ChromeDriver(); 
	default: throw new  RuntimeException("Unsupported webdriver: " + webdriver); 
	 }
	 } 
   
   
   	public void tearDown(Scenario scenario) throws IOException {
    //   Scenario scenario=(Scenario)testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
       if (scenario.isFailed()) {
       String screenshotName = scenario.getName().toString();
       //.replaceAll("", "");
       try {
       TakesScreenshot ts = (TakesScreenshot) driver;
       byte[] sourcePath = ts.getScreenshotAs(OutputType.BYTES);
       File destinationPath = new File("C:\\Users\\venka\\eclipse-workspace\\cucumberTng" + "\\target\\cucumber-reports\\screenshots\\" + screenshotName + ".png");
     //  System.getProperty((“user.dir”) + “\\target\\cucumber-reports\\screenshots\\” + screenshotName + “.png”);
     //  FileUtils.copyFile(sourcePath, destinationPath);
       scenario.embed(sourcePath, "image/png"); 
       
         if (driver != null ) {
       	  driver.quit();
	}
    //   Reporter.addScreenCaptureFromPath(destinationPath.toString());
       } catch (WebDriverException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
       }

       }
   }
   	
   	public String getpageTitle() throws Exception
	{
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return driver.getTitle();
		 
		
	}





}
	  
	/*  private WebDriver createWebDriver() {
	        switch (driverType) {     
	        case FIREFOX : driver = new FirefoxDriver();
	     	break;
	        case CHROME : 
	        //	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
	        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\chromedriver.exe");
	        	driver = new ChromeDriver();
	     break;
	        }
	 */
	    //    if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
	        
	 
	 



