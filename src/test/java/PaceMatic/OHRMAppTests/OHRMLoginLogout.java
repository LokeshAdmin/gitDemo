package PaceMatic.OHRMAppTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.OrangeHRMHomePage;
import objectRepository.OrangeHRMLoginPage;
import resources.Base;

public class OHRMLoginLogout extends Base {
	public static Logger log = LogManager.getLogger(OHRMForgotPasswordTest.class.getName());
	public WebDriver driver;
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver = initializeDriver();
	}
	
	@Test (groups = "Smoke")
	public void mainMethod() {
		OrangeHRMLoginPage lp =new OrangeHRMLoginPage(driver);
		OrangeHRMHomePage hp = new OrangeHRMHomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		boolean isLoginLogo  = lp.getoHRMLogo().isDisplayed();
		if(isLoginLogo==true) {
			System.out.println("StepPass:On Login Page");
			lp.getUsername().sendKeys("admin");
			lp.getPassword().sendKeys("admin123");
			lp.getLoginBtn().click();
			boolean ishomeLogo = hp.getHomeLogo().isDisplayed();
			if(ishomeLogo==true) {
				System.out.println("StepPass:On Home Page");
			    String user = hp.getLoggedInUser().getText();
			    System.out.println("User:" + user.substring(8));
			    hp.getLoggedInUser().click();
			    hp.getLogout().click();
			    boolean isLoginPanel = lp.getLoginPanel().isDisplayed();
			    if (isLoginPanel==true) {
			    	System.out.println("StepPass:On login Page after logout");
				}
			    else {
			    	System.out.println("StepFail: Not on login page after logout");
				}
			}
			else {
				System.out.println("StepFail: Not on Home page");
			}
		}
		else {
			System.out.println("StepFail: Not on login page");
		}
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
