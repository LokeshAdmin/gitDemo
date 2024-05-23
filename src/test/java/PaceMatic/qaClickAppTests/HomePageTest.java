package PaceMatic.qaClickAppTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.QAClickLandingPage;
import objectRepository.QAClickLoginPage;
import resources.Base;

public class HomePageTest extends Base{
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	public WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException{
		driver = initializeDriver();
    	driver.get(prop.getProperty("url1"));
	}
    @Test (dataProvider="getData")
    public void BasePageNavigation(String username, String Password, String test){
    	log.info("Successfully navigated to the website");
    	QAClickLandingPage lp = new QAClickLandingPage(driver);
    	if (lp.getDynamicPopup().size()>0) {
			lp.getDynamicPopup().get(0).click();
		}
    	lp.getLogin().click();
    	log.info("Successfully Clicked on login");
    	QAClickLoginPage loP = new QAClickLoginPage(driver);
    	loP.getEmail().sendKeys(username);
    	loP.getPassword().sendKeys(Password);
    	//loP.getLogin().click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", loP.getLogin());
    	log.error("Login is not successful");
    	log.info(test);
    }
    
    @AfterMethod
    public void tearDown(){
    	driver.close();
    }
    @DataProvider
    public String[][] getData(){
    	//row stand for how many different data types tests should run
    	//column stands for how many values for each tests
    	String[][] data =new String[3][3];
    	//0th row
    	data[0][0]="ab@bc.com";
    	data[0][1]="pass1";
    	data[0][2]="test1";
    	//1st row
    	data[1][0]="cd@de.com";
    	data[1][1]="pass2";
    	data[1][2]="test2";
    	
    	//2nd row
    	data[2][0]="fg@hi.com";
    	data[2][1]="pass3";
    	data[2][2]="test3";
    	
    	return data;
    }
}
