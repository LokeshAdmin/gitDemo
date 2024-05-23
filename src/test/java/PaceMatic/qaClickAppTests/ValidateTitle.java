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

public class ValidateTitle extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException{
		driver = initializeDriver();
    	driver.get(prop.getProperty("url1"));
		
	}
	@Test (groups = "Smoke")
	public void TitleTest(){
		QAClickLandingPage l = new QAClickLandingPage(driver);
    	Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
    	log.info("Feature course is displayed");
    	
	}
	@AfterMethod
    public void tearDown(){
    	driver.close();
    }

}
