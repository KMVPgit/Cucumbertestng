package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tContext.testContext;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class refersignupPage {
	
	WebDriver driver;
	pageObjectsManager pageobjectsmanger;
	Logger log;
	PageBase pagebase;
	
	refersignupPage(WebDriver driver) throws IOException{
		this.driver = driver ;
		PageFactory.initElements(driver,this);
		 log = LogManager.getLogger("refersignupPage.logger");
		 pagebase =	testContext.getpageobjectsmanager().getPageBase();
	}
	 @FindBy(xpath="//div[1]/div[4]//div[1]//div/span")
	 WebElement signupbygmail;
	 
	 public refersignupPage clicksignupbygmail() {
		 try {
		 signupbygmail.click();
		 log.info("Clicked on Signupbygmail");
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return(refersignupPage.this);
	 }

}
