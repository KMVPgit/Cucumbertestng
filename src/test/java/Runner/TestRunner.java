package Runner;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

//import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\src\\test\\java\\Features\\",
		//"C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\src\\test\\java\\Features\\login.feature",
		glue = {"StepDefinition"},
		tags ="",
		format = {"pretty", "html:target/cucumber-reports/cucumber-pretty/"  },
		plugin = "json:target/cucumber-reports/CucumberTestReport.json/" ,
		//"your.package.TestEventHandlerPlugin",
		
		monochrome = true,
		dryRun = false
				
		)
//To run features in a specific sequence by naming them like 01_File.feature

//@Cucumber.Options(features={"File1.feature", "File3.feature","File2.feature"})

public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	WebDriver driver;
	
	
	@BeforeClass(alwaysRun = true)
 public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
			}
	
//	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
  //  @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
	}
	
	
	
	@After
	public void tearDownss(Scenario scenario) throws IOException {
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
	
	/*@Before	
	public WebDriver initializedriver() throws IOException {
		webdrivermanager = new WebDriverManager();
		driver = webdrivermanager.getDriver();
        return (driver);
	}*/
	/*@After
	 public void tearDownss(Scenario scenario) {
	if(scenario.isFailed()) {
	   String filePath = WebUI.takeScreenshot()
	   File file = new File(filePath)
	   scenario.embed(Files.readAllBytes(file.toPath()), "image/png")	
	  }
	'Close Browser'
	  WebUI.closeBrowser()
	 }
	See complete implement for Selenium:
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	      // Take a screenshot...
	      final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
	   // embed it in the report.
	      scenario.embed(screenshot, "image/png"); 
	    }
	}
	
	
	
	*/
	
	/*
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

    

	
	
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass (alwaysRun = true)
		public void teardown() throws Exception {
			testNGCucumberRunner.finish();
			if (driver != null ) {driver.quit();
			}
		}
	}
	
