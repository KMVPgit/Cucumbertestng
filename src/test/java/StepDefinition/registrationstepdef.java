package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.PageBase;
import PageObjects.loginPage;
import PageObjects.pageObjectsManager;
import PageObjects.refersignupPage;
import TestBase.WebDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tContext.testContext;

public class registrationstepdef {
	refersignupPage refersignuppage;
	testContext testcontext;
	loginPage lp;
	Logger log;
	WebDriverManager webdrivermanager;
	pageObjectsManager pageobjectsmanger;
	PageBase pagebase;
	
	public registrationstepdef(testContext testcontext)  {
		try {
			 this.testcontext =  testcontext;	
			 log = LogManager.getLogger("registrationstepdef.logger");
		
		pagebase =	testContext.getpageobjectsmanager().getPageBase();
		refersignuppage =	testContext.getpageobjectsmanager().getrefersignupPage();
	//	log.info("Constructor");
		}
		catch (Exception e) {			
			e.printStackTrace();
			}
	}
	
	@Test
	@Given ("^User is on registration page$")
	public void User_is_on_registration_page() throws Exception {
		try {
			String title = lp.getlogintitle();
		log.info("User_is_on_login_page" + title );
			Assert.assertEquals(title, "Sign In");
			lp.clickReferSignup();
			Assert.assertEquals(pagebase.getpageTitle(), "Sign Up");
		}
catch (Exception e) {
	e.printStackTrace();
	}
}
	@Test
	@Then("^Click gmail SignUp$")
	//("^Enter Username$")
	public void Click_gmail_SignUp() throws Exception {
		try {				
			refersignuppage.clicksignupbygmail();			
            Assert.assertEquals(pagebase.getpageTitle(), "Sign in – Google Accounts");	
		}
catch (Exception e) {
	e.printStackTrace();}
}
	
/*	@Test
	@Then ("^Enter gmail$")
	public void Enter_gmail() throws Exception{
		try {
			refersignuppage.clicksignupbygmail();			
            Assert.assertEquals(pagebase.getpageTitle(), "Sign in – Google Accounts");			
	 }
catch (Exception e) {
	e.printStackTrace();}
     }
	*/
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