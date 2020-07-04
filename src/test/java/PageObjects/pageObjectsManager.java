package PageObjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;

public class pageObjectsManager {
	
	
	private WebDriver driver;
	private loginPage loginpage;
	private homePage homepage;
	private registrationPage registrationpage;
	private PageBase pagebase;
	private refersignupPage refersignuppage;
	
	
	public pageObjectsManager(WebDriver driver){
		this.driver = driver;
	}
	
	public loginPage getloginpage() throws IOException {
		
		return (loginpage == null) ? loginpage =new loginPage(driver) : loginpage;
	}
    public homePage gethomepage() throws IOException {
		
		return (homepage == null) ? homepage =new homePage(driver) : homepage;
	}
    
    public registrationPage getregistrationPage() throws IOException {
		
		return (registrationpage == null) ? registrationpage =new registrationPage(driver) : registrationpage;
	}
    
public refersignupPage getrefersignupPage() throws IOException {
		
		return (refersignuppage == null) ? refersignuppage =new refersignupPage(driver) : refersignuppage;
	}
    
public PageBase getPageBase() throws IOException {
		
		return (pagebase == null) ? pagebase = new PageBase(driver) : pagebase;
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
           
             
        //   Reporter.addScreenCaptureFromPath(destinationPath.toString());
           } catch (WebDriverException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           }

           }
       }
    
    public void closeBrowser() {
    	if (driver != null) {
         	  driver.quit();
  	}
    }

}

