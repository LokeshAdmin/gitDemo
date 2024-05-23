package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMForgotPasswordPage {
	
	WebDriver driver;
	
	public OrangeHRMForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//private By forgotPasswordHeading = By.xpath("");
	//private By authenticationUsername = By.id("securityAuthentication_userName");
	//private By resetPassword = By.xpath("//input[@value='Reset Password']");
	//private By resetRequestMessage = By.className("message warning fadable");
	
	@FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
	private WebElement forgotPasswordHeading;
	
	@FindBy(id="securityAuthentication_userName")
	private WebElement authenticationUsername;
	
	@FindBy(xpath="//input[@value='Reset Password']")
	private WebElement resetPassword;
	
	@FindBy(xpath="//div[@class='message warning fadable']")
	private WebElement resetRequestMessage;
	
	public WebElement getForgotPasswordHeading() {
		try {
			return forgotPasswordHeading;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public WebElement getAuthenticationUsername() {
		try {
			return authenticationUsername;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public WebElement getResetPassword() {
		try {
			return resetPassword;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public WebElement getResetRequestMessage() {
		
		try {
			return resetRequestMessage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
