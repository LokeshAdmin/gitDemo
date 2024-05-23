package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage {
	WebDriver driver;
	public OrangeHRMHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//private By homeLogo = By.xpath("//img[contains(@src,'images/logo.png')]");
	//private By loggedInUser = By.id("welcome");
	//private By logout = By.xpath("//a[text()='Logout']");
	
	@FindBy(xpath = "//img[contains(@src,'images/logo.png')]")
	private WebElement homeLogo;
	
	@FindBy(id = "welcome")
	private WebElement loggedInUser;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	public WebElement getHomeLogo() {
		try {
			return homeLogo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public WebElement getLoggedInUser() {
		
		try {
			return loggedInUser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public WebElement getLogout() {
		try {
			return logout;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

