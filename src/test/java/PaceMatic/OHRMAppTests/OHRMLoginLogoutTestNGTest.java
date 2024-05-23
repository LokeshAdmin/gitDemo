package PaceMatic.OHRMAppTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.OrangeHRMHomePage;
import objectRepository.OrangeHRMLoginPage;
import resources.Base;

public class OHRMLoginLogoutTestNGTest extends Base {
	public static Logger log = LogManager.getLogger(OHRMForgotPasswordTest.class.getName());
	public WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	
	
	@BeforeClass
	public void LaunchOrangeHRM() throws IOException {
		driver = initializeDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		//driver = new ChromeDriver();
		lp =new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void loginLogoutTest() {
		boolean isLoginLogo  = lp.getoHRMLogo().isDisplayed();
		Assert.assertTrue(isLoginLogo, "StepFail: Not on login page | ");
		System.out.println("StepPass:On Login Page");
		lp.getUsername().sendKeys("admin");
		lp.getPassword().sendKeys("admin123");
		lp.getLoginBtn().click();
		boolean ishomeLogo = hp.getHomeLogo().isDisplayed();	
		Assert.assertTrue(ishomeLogo, "StepFail: Not on Home page | ");	
		System.out.println("StepPass:On Home Page");	
		String user = hp.getLoggedInUser().getText();
	    System.out.println("User:" + user.substring(8));
	    hp.getLoggedInUser().click();
	    hp.getLogout().click();
	    boolean isLoginPanel = lp.getLoginPanel().isDisplayed();
		Assert.assertFalse(isLoginPanel,"StepFail: Not on login page after logout");	    
		System.out.println("StepPass:On login Page after logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
