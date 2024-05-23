package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class Base 
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public Properties prop;
	public String basePath = System.getProperty("user.dir");
	public WebDriver initializeDriver() throws IOException{
	   log.debug("Initializing Driver");
	   basePath = System.getProperty("user.dir");
	   String propertiesPath = basePath + "\\src\\main\\java\\resources\\data.properties";
	   prop = new Properties();
	   FileInputStream fis = new FileInputStream(propertiesPath);
	   prop.load(fis);
	   String browserName = prop.getProperty("browser");
	   if(browserName.equals("chrome")){
		   System.setProperty("webdriver.chrome.driver", basePath+"\\chromedriver.exe");
		   driver = new ChromeDriver();
	   }
	   else if(browserName.equals("firefox")){
		   System.setProperty("webdriver.gecko.driver", basePath+"\\geckodriver.exe");
		   driver = new FirefoxDriver();
	   }
	   else if(browserName.equals("ie")){
		   System.setProperty("webdriver.ie.driver", basePath+"\\IEDriverServer.exe");
		   driver = new InternetExplorerDriver();
	   }
	   else if(browserName.equals("edge")){
		   System.setProperty("webdriver.edge.driver", basePath+"\\msedgedriver.exe");
		   driver = new EdgeDriver();
	   }
	   else {
		   log.error("Invalid browser, please specify correct browser name in the properties file");
		   Assert.assertFalse(true,"Invalid browser, please specify correct browser name in the properties file");
	   }
	   driver.manage().window().maximize();
	   log.info("Windows Maximized");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   log.debug("Implicit wait set as 10 seconds");
	   log.info("Successfully initialized driver, browser launched successfully");
	   return driver;
	}
	
	public String getScreenshot(String result, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = basePath+"\\Screenshots\\"+ result +"screenshot.png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}
}

