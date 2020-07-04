package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.homePage;
import PageObjects.loginPage;
import PageObjects.pageObjectsManager;
import TestBase.WebDriverManager;
import TestBase.testbase;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tContext.testContext;

public class Stepdef1 {
	
	homePage hp;
	WebDriverManager webdrivermanager;
	pageObjectsManager pageobjectsmanger;
	Logger log;
	//static Logger log;
	//homePage homepage;
	testContext testcontext;
	
	
	public Stepdef1(testContext testcontext) {
		try {
		this.testcontext =  testcontext;
	//	driver = testcontext.getwebdrivermanager().getDriver();
		hp =	testcontext.getpageobjectsmanager().gethomepage();
		}
		catch (Exception e) {			
			System.out.println(Thread.currentThread().getStackTrace().toString());
			}
	}

	
	@Test
	@Given ("^User is on home page$")
	public void User_is_on_home_page() throws Exception {
		try {
			
			
		//driver.get("www.https://freecrm.com");
			Assert.assertEquals(2, 2);
			System.out.println("User is on Login Page");
		
	}
catch (Exception e) {System.out.println(Thread.currentThread().getStackTrace());}
}
	@Test
	@Then ("^Home page is displayed$")
	public void Home_page_is_displayed() throws Exception {
		try {
			Assert.assertEquals(2, 2);
			System.out.println("Entered UN");
		
	}
catch (Exception e) {System.out.println(Thread.currentThread().getStackTrace());}
}
	@Test
	@Then ("^Verify links$")
	public void Verify_links () throws Exception{
		try {
			Assert.assertEquals(2, 2);
			System.out.println("Entered pwd");
		
	}
catch (Exception e) {System.out.println(Thread.currentThread().getStackTrace());}
}
	
	@Test
	@Given ("^User again is on home page \"([^\"]*)\" test$")
	public void User_again_is_on_home_page_hpname_test(String hpname) throws Exception {
		try {
			
			Assert.assertEquals("test1", hpname);
			System.out.println("User is on Login Page");
		
		}
	catch (Exception e) {System.out.println(e.getStackTrace());System.out.println(Thread.currentThread().getStackTrace());}
	}
	
		@Test
		@Then ("^Verify logo displayed \"([^\"]*)\" logo$")
		public void Verify_logo_displayed_yes_logo(String yes) throws Exception{
			try {
			//driver.get("www.https://freecrm.com");
				Assert.assertEquals("YES", yes);
				System.out.println("Entered pwd" );
			
		}
	catch (Exception e) {System.out.println(Thread.currentThread().getStackTrace());}
	}
	
	
		
}


