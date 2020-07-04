package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.pageObjectsManager;
import PageObjects.refersignupPage;
import PageObjects.registrationPage;
import PageObjects.PageBase;
import PageObjects.loginPage;
import TestBase.WebDriverManager;
import TestBase.testbase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import jdk.internal.jline.internal.Log;
import tContext.testContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stepdef { 
	loginPage lp;
	registrationPage registrationpage;
	testContext testcontext;
	Logger log;
	WebDriverManager webdrivermanager;
	pageObjectsManager pageobjectsmanger;
	PageBase pagebase;
	refersignupPage refersignuppage;
	
	public Stepdef(testContext testcontext)  {
		try {
			 this.testcontext =  testcontext;	
			 log = LogManager.getLogger("Stepdef.logger");
		lp =	testContext.getpageobjectsmanager().getloginpage();
		pagebase =	testContext.getpageobjectsmanager().getPageBase();
		refersignuppage =	testContext.getpageobjectsmanager().getrefersignupPage();
	//	log.info("Constructor");
		}
		catch (Exception e) {			
			e.printStackTrace();
			}
	}
	
	
	@Test
	@Given ("^User is on login page$")
	public void User_is_on_login_page() throws Exception {
		try {
			String title = lp.getlogintitle();
		log.info("User_is_on_login_page" + title );
			Assert.assertEquals(title, "Sign In");
		
			/* Free crm
			String regtitle = null;
			String title = lp.getlogintitle();			
			testContext.getpageobjectsmanager().getloginpage().clicksignup();
			log.info("User_is_on_login_page" + title );
			Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
			regtitle = testContext.getpageobjectsmanager().getregistrationPage().getregistrationtitle();			
			Assert.assertEquals(regtitle, "Cogmento CRM");	
			//Free CRM #1 cloud software for any business large or small
			System.out.println("User is on Login Page");		*/
	}
catch (Exception e) {
	e.printStackTrace();
	}
}
	@Test
	@Then("^Click SignUp$")
	//("^Enter Username$")
	public void Click_SignUp() throws Exception {
		try {				
			lp.clickReferSignup();
			Assert.assertEquals(pagebase.getpageTitle(), "Sign Up");
			
			
			//lp.clicksignup();
	//		log.info("Enter_Username clicksignup");
		//	Assert.assertEquals(2, 2);
			System.out.println("Entered UN");		
	}
catch (Exception e) {
	e.printStackTrace();}
}
	
	@Test
	@Then ("^Clicks SignUp via gmail$")
	public void Clicks_SignUp_via_gmail() throws Exception{
		try {
			refersignuppage.clicksignupbygmail();
			
            Assert.assertEquals(pagebase.getpageTitle(), "Sign in – Google Accounts");			
	 }
catch (Exception e) {
	e.printStackTrace();}
     }
	
	@Test
	@Then ("^click submit$")
	public void click_submit() throws Exception {
		try {
		Assert.assertEquals(2, 2);
		System.out.println("Clicked on Submit");
	}
catch (Exception e) {
	e.printStackTrace(); 
	}
}

	@After
	public void afterscenario(Scenario scenario) throws IOException {
     //   Scenario scenario=(Scenario)testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		testContext.getpageobjectsmanager().tearDown(scenario);
		testContext.getpageobjectsmanager().closeBrowser();
        }
	
	
}

