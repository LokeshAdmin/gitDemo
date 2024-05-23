package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.OrangeHRMHomePage;
import objectRepository.OrangeHRMLoginPage;
import resources.Base;

public class StepDefinition extends Base{
	public WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	
	//Given User is on Login Page
	@Given("^User is on Login Page$")
	public void user_is_on_login_page() throws IOException {
		driver = initializeDriver();
		lp = new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM","StepFail:User is not on login page");
		System.out.println("StepPass:User is on Login page");
		
	}
	////This method is used for multiple usernames and passwords (arrays)argument
	@When("^User clicks on login by entering Username as (.+) and Password as (.+)$")
	public void user_clicks_on_login_by_entering_username_as_and_password_as(String username, String password) throws Throwable {
		username = username.replaceAll("\"", "");
		password = password.replaceAll("\"", "");
		lp.getUsername().sendKeys(username);
        lp.getPassword().sendKeys(password);
        lp.getLoginBtn().click();
	}
	//This method is used for single username and password argument
	/*@When("^User clicks on login by entering Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void user_clicks_on_login_by_entering_username_as_something_and_password_as_something(String username, String password) throws Throwable {
		lp.getUsername().sendKeys(username);
        lp.getPassword().sendKeys(password);
        lp.getLoginBtn().click();
        
    }*/
	//Normal step definition without parameters passed from feature file
	/*@When("^User clicks on login by entering Username and Password$")
    public void user_clicks_on_login_by_entering_username_and_password() throws Throwable {
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
    }*/
	
	@Then("^login success is \"([^\"]*)\"$")
    public void login_success_is_something(String strArg1) throws Throwable {
		strArg1 = strArg1.replaceAll("\"", "");
		boolean isHomeLogo = false;
		try {
			isHomeLogo = hp.getHomeLogo().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (strArg1.equals("true")) {
			Assert.assertTrue(isHomeLogo,"StepFail: Login failed");
	        System.out.println("StepPass:Login successful");
	        
		}
		else {
			Assert.assertFalse(isHomeLogo,"StepFail: Login is successful using invalid Credential");
	        System.out.println("StepPass:Login is unsuccessful");
	       
		}
		
    }

    @And("^Username displayed is \"([^\"]*)\"$")
    public void username_displayed_is_something(String strArg1) throws Throwable {
    	strArg1 = strArg1.replaceAll("\"", "");
    	boolean isUser = false;
		try {
			isUser = hp.getLoggedInUser().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (strArg1.equals("true")) {
			Assert.assertTrue(isUser,"StepFail:Username is not displayed");
	        System.out.println("StepPass:Username is displayed");
		}
		else {
        	Assert.assertFalse(isUser,"StepFail:Username not displayed");
        	System.out.println("StepPass:Username is not displayed");
		}
   	 	
    }
	
	/*
    @Then("^Login should be successful$")
    public void login_should_be_successful() throws Throwable {
        boolean isHomeLogo = driver.findElement(By.xpath("//img[contains(@src,'default/images/logo.png')]")).isDisplayed();
        if(isHomeLogo==true) {
        	System.out.println("StepPass:Login successful");
        }
        else {
			System.out.println("StepFail: Login failed");
		}
    }*/
	
	/*
    @And("^Username is displayed$")
    public void username_is_displayed() throws Throwable {
    	boolean isUser = driver.findElement(By.id("welcome")).isDisplayed();
    	 if(isUser==true) {
         	System.out.println("StepPass:Username is displayed");
         }
         else {
 			System.out.println("StepFail:Username is not displayed");
 		}
    	driver.quit();
    }*/
    
    @And("^close browser$")
    public void close_browser() {
        driver.quit();
    }
}
