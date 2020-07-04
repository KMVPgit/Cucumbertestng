package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public  class PageBase {
	
	
	WebDriver driver;
	pageObjectsManager pageobjectsmanger;
	Logger log;
  //  Wait<WebDriver> wait;

	
	public PageBase(WebDriver driver) throws IOException {
		
		this.driver = driver;
		 log = LogManager.getLogger("loginPage.logger");
			PageFactory.initElements(driver, this);
	}
	
	//WebDriverWait wait = new WebDriverWait(driver,30);
 
	// Define the basic methods for each element type actions
	
	public Wait getwait() {
	Wait wait = new FluentWait(driver)
			 .withTimeout(Duration.ofSeconds(30))
		       .pollingEvery(Duration.ofSeconds(5))
		       .ignoring(NoSuchElementException.class);
	return wait;
	}
	
	/*WebElement foo = wait.until(new Function<WebDriver, WebElement>() {	
	     public WebElement apply(WebDriver driver) {
	     WebElement wbElmt =   driver.findElement(By.id("foo"));
	     if (wbElmt != null)
	     return wbElmt ;
		return wbElmt;
	     }
	  });*/
	
	
	public void enterText(WebElement field, String tdata) throws Exception
	{
		field.sendKeys(tdata);
		
	}
	
	public String getpageTitle() throws Exception
	{
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return driver.getTitle();
		 
		
	}
	//returns select object
	
	public Select selectDropDown(WebElement dd) throws Exception
	{
		Select sdd = new Select(dd);
		return sdd;
	}
	
	public void selectCheckbox(WebElement field) throws Exception
	{
		if (!(field.isSelected())){
			field.click();
		}
		
	}
	
	public Actions actobj() throws Exception
	{
		Actions action = new Actions(driver);
		return action ;
		
	}
	
	protected <TPage extends PageBase> TPage getInstance(Class <TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}