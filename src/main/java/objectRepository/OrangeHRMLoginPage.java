package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {
	WebDriver driver;
	public OrangeHRMLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//private By oHRMLogo = By.xpath("//img[contains(@src,'login/logo.png')]");
	//private By loginPanel = By.id("logInPanelHeading");
	//private By username = By.id("txtUsername");
	//private By password = By.id("txtPassword");
	//private By loginBtn = By.id("btnLogin");
	//private By invalidCredentialsMessage = By.id("spanMessage");
	//private By forgotPasswordLink = By.linkText("Forgot your password?");
	
	@FindBy(xpath = "//img[contains(@src,'login/logo.png')]")
	private WebElement oHRMLogo;
	
	@FindBy(id = "logInPanelHeading")
	private WebElement loginPanel;
	
	@FindBy(id = "txtUsername")
	private WebElement username;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(id = "btnLogin")
	private WebElement loginBtn;
	
	@FindBy(id = "spanMessage")
	private WebElement invalidCredentialsMessage;
	
	@FindBy(linkText = "Forgot your password?")
	private WebElement forgotPasswordLink;

	
	public WebElement getoHRMLogo() {
		
		try {
			return oHRMLogo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public WebElement getLoginPanel() {
		
		try {
			return loginPanel;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public WebElement getUsername() {
		
		try {
			return username;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public WebElement getPassword() {
		
		try {
			return password;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public WebElement getLoginBtn() {
		
		try {
			return loginBtn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public WebElement getInvalidCredentialsMessage() {
		
		try {
			return invalidCredentialsMessage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public WebElement getForgotPasswordLink() {
		
		try {
			return forgotPasswordLink;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
