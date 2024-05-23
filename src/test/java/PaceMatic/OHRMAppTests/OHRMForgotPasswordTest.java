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

import objectRepository.OrangeHRMForgotPasswordPage;
import objectRepository.OrangeHRMHomePage;
import objectRepository.OrangeHRMLoginPage;
import resources.Base;

public class OHRMForgotPasswordTest extends Base{
	public static Logger log = LogManager.getLogger(OHRMForgotPasswordTest.class.getName());
	public WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	OrangeHRMForgotPasswordPage fp; 
	
	@BeforeClass
	public void LaunchOrangeHRM() throws IOException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver = initializeDriver();
		lp =new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
		fp = new OrangeHRMForgotPasswordPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void ForgotPasswordTest() {
		boolean isLoginLogo  = lp.getoHRMLogo().isDisplayed();
		Assert.assertTrue(isLoginLogo, "StepFail: Not on login page | ");
		System.out.println("StepPass:On Login Page");
		log.info("StepPass:On Login Page");
		
		lp.getUsername().sendKeys("admin");
		lp.getPassword().sendKeys("admin321");
		lp.getLoginBtn().click();
		boolean ishomeLogo = false;
		try {
			ishomeLogo = hp.getHomeLogo().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.error("StepFail: User Logged in with invalid credentials");
		Assert.assertFalse(ishomeLogo, "StepFail: User Logged in with invalid credentials | ");	
		System.out.println("StepPass:User unable to login with invalid credentials");	
		String invalidMessage =  lp.getInvalidCredentialsMessage().getText();
		Assert.assertEquals(invalidMessage, "Invalid credentials","StepFail: Invalid credential message is not displayed");
		System.out.println("StepPass: Invalid credential message is displayed");
		lp.getForgotPasswordLink().click();
		boolean isHeading =  fp.getForgotPasswordHeading().isDisplayed();
		Assert.assertTrue(isHeading, "StepFail:Not on forgot password page");
		System.out.println("StepPass: on forgot password page");
		fp.getAuthenticationUsername().sendKeys("admin");
		fp.getResetPassword().click();
		String resetRequestMessage =  fp.getResetRequestMessage().getText();
		String expectedString = "There is a password reset request already in the system.";
		boolean result = resetRequestMessage.contains(expectedString);
		
		Assert.assertTrue(result,"StepFail: incorrect reset request message");
		log.error("StepFail: incorrect reset request message");
		System.out.println("StepPass: Found the reset request message successfully");
		log.info("StepPass: Found the reset request message successfully");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
