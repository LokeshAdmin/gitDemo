package PaceMatic.qaClickAppTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import objectRepository.QAClickLandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException{
		driver = initializeDriver();
		log.info("Successfully initialized the driver");
    	driver.get(prop.getProperty("url1"));
    	log.info("Successfully launched website");
		
	}
	@Test (groups = "Smoke")
	public void NavigationBarTest() throws IOException{
		
		QAClickLandingPage lp = new QAClickLandingPage(driver);
		if (lp.getDynamicPopup().size()>0) {
			lp.getDynamicPopup().get(0).click();
		}
    	Assert.assertTrue(lp.getNavigationBar().isDisplayed());
    	log.info("Navigation bar is displayed");
    	Assert.assertFalse(lp.getNavigationBar().isDisplayed());
    	log.error("Navigation bar is not displayed");
	}
	@AfterMethod
    public void tearDown(){
    	driver.close();
    }

}
