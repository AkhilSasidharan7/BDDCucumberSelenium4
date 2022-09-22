package mottMac;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


//WebDriver defined. Additional drivers can be added if required. 

public class SetupBrowser {
    public static WebDriverWait wait;
    public static Logger log;
    public static WebDriver driver;
    
    public static void setUp()
    {
        log = SetupLog.setUp();
        log.info("Initializing Browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, CareerSearch.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        log.info("Browser launched");
    }

    //Closing the browser
	public static void closeBrowser() {
		
		driver.quit();
	}

}
