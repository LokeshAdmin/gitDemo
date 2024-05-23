package PaceMatic.OHRMAppTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibraries.ExcelLibrary;
import resources.Base;

public class OHRMDataDrivenTest extends Base {
	public static Logger log = LogManager.getLogger(OHRMForgotPasswordTest.class.getName());
	public WebDriver driver;
	ExcelLibrary exObj;
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver = initializeDriver();
	}
	
	@Test
	public void LoginDDTTest() throws EncryptedDocumentException, IOException {
		exObj = new ExcelLibrary();
		exObj.LoadAllExcelData();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		int listSize = exObj.getUnames().size();
		for(int i = 0;i<=listSize-1;i++) {
			log.debug("Username: " + exObj.getUnames().get(i));
			log.debug("Password: " + exObj.getPwords().get(i));
			driver.findElement(By.id("txtUsername")).sendKeys(exObj.getUnames().get(i));
			driver.findElement(By.id("txtPassword")).sendKeys(exObj.getPwords().get(i));
			driver.findElement(By.id("btnLogin")).click();
			WebElement welcome = null;
			boolean isHomeVisible=false;
			try {
				welcome = driver.findElement(By.id("welcome"));
				isHomeVisible = welcome.isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isHomeVisible==true) {
				log.info("StepSuccess: Credentials are working");
				welcome.click();
				driver.findElement(By.xpath("//a[text()='Logout']")).click();
			}
			else {
				log.error("StepFail: Credentials are not working");
			}
			
			boolean isloginVisible =  driver.findElement(By.xpath("//div[text()='LOGIN Panel']")).isDisplayed();
			if (isloginVisible) {
				log.info("StepSuccess: Logout successful");
			}
			else {
				log.error("StepFail: Logout unsuccessful");
			}
			
		}
		
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
