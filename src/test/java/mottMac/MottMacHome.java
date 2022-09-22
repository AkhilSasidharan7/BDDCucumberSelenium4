package mottMac;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class MottMacHome extends SetupBrowser {

	static By cookies_accept = By.id("ccc-notify-accept");
	static By language_select = By.xpath("//a[contains(text(),'Global')]");
	static String url = "";

	public static void launchApp() {
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mottmac.com");
		wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
		wait.until(ExpectedConditions.elementToBeClickable(language_select)).click();
		log.info("Application is launched.");
	}

	//Verifying all the links available in the application and validating the URL format.
	public static void verifyLinks() throws InterruptedException, MalformedURLException, IOException, URISyntaxException {
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total No.of links:" + links.size());
		
		for(int i=1;i<links.size();i++)
		{
			url = links.get(i).getAttribute("href");
			new URL(url).toURI();
		}

	

	}

}
