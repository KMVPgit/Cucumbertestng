package PageObjects;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import PageObjects.PageBase;
import org.openqa.selenium.support.PageFactory;

public class registrationPage{
	
	WebDriver driver;
	Logger log;
	pageObjectsManager pageobjectsmanger;
	PageBase pagebase;
		
	
	public registrationPage(WebDriver driver) throws IOException {
		
	this.driver = driver;
			PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
	
	@FindBy(id= "//*[@id='email']")
	WebElement emailId;
	
	
	public String  getPagetitl() {
		try {
			return (driver.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Registrationtitle not returned";
	 }
	
	
	
	
	 public String getregistrationtitle() {
		try {
			return (pagebase.getpageTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Registrationtitle not returned";
	 }
	
	public registrationPage enterEmailId() {
		try {
			pagebase.enterText(emailId , "test123@rediffmail.com");
			log.info("Registration emailid entered");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (registrationPage.this);
	}
	

}
