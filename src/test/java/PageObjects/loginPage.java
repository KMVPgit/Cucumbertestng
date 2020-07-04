package PageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage  {
	
	
	WebDriver driver;
//	utilitieshelp log;
	pageObjectsManager pageobjectsmanger;
	Logger log;
	
	public loginPage(WebDriver driver) throws IOException {
		
	this.driver =driver;
	 log = LogManager.getLogger("loginPage.logger");
			PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
		
	@FindBy(name="")
	WebElement username ;
	
	@FindBy(name="")
	WebElement pwd ;

	@FindBy(xpath="")
	WebElement submitbtn ;
	
	@FindBy(xpath="//div[1]/main/section[1]/a")
	WebElement signupbtn ;
	
	@FindBy(xpath="//div[1]/main/section[1]/a")
	WebElement homepagebtn ;
	
	/* Above for freecrm
	 * 

	 */
	
	@FindBy(xpath="//*[@id='header']/div/ul/li/button")
	WebElement refersinin ;
	
	
	@FindBy(xpath="/html/body/div/div[1]/div[4]/div/div[1]/div/div/span")
	WebElement signupwithggle;
	
	
		
	public String getlogintitle() {
		try {
		String t = driver.getTitle();
		log.info("Login page title = " + t);
		return t;
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return ("title not found exception");
	}
	
	public loginPage clickReferSignup() {
		try {
		refersinin.click();		
		}
		catch (Exception e) {
			e.printStackTrace();}
		return (loginPage.this);
	}
	
	public void clickhomepagebtn() throws Exception{
		
		String t = driver.getTitle();
		//log.info("title = " + t);
	}
	
	public loginPage clicksignup() throws Exception{
		try {
		String t = driver.getTitle();
		if(signupbtn.isEnabled())
	//	log.info("title = " + t);
		{signupbtn.click();
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		return (loginPage .this);
	}
	public void enterun(WebElement username, String un) throws Exception{
		username.sendKeys("un");
	}
		
}

