package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAClickLandingPage{
	public WebDriver driver;
	public QAClickLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://rahulshettyacademy.com/sign_in/']")
	private WebElement signIn;
	
	@FindBy(xpath="//h2[normalize-space()='Featured Courses']")
	private WebElement title;
	
	@FindBy(xpath="//a[@href='https://rahulshettyacademy.com/sign_in/']")
	private WebElement navigationBar;
	
	@FindAll(@FindBy(xpath="//button[text()='NO THANKS']"))
	private List<WebElement> dynamicPopup;
	
	public WebElement getLogin(){
		return signIn;
	}
	
	public WebElement getTitle(){
		return title;
	}
	
	public WebElement getNavigationBar(){
		return navigationBar;
	}
	
	public List<WebElement> getDynamicPopup(){
		return dynamicPopup;
	}
	
}
