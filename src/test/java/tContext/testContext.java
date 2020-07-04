package tContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.PageBase;
import PageObjects.pageObjectsManager;
import TestBase.WebDriverManager;
import help.utilitieshelp;

public class testContext {
	private static pageObjectsManager pageobjectsmanager;
	private static PageBase pagebase;
	//private scenarioContext scenariocontext;
	private WebDriverManager webdrivermanager;
	final Logger log;

	public String configfilepath = "C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\src\\test\\java\\help\\config.txt";
	
	public testContext() throws Exception {
		
		  log = LogManager.getLogger("testContext.logger");

		// BasicConfigurator.configure();
		// prop = new Properties();
	//	 up = new utilitieshelp(configfilepath);
	//FileInputStream is = new FileInputStream("C:\\Users\\venka\\eclipse-workspace\\cucumberTng\\src\\test\\java\\help\\config.txt");
	//prop.load(is);
		webdrivermanager = new WebDriverManager(configfilepath);
		pageobjectsmanager = new pageObjectsManager(webdrivermanager.getDriver());
			
	}
  public WebDriverManager getwebdrivermanager (){
	   return  webdrivermanager;
  }
  
  public static pageObjectsManager getpageobjectsmanager (){
	   return  pageobjectsmanager;
 }
}
