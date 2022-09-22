package mottMac;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class CareerSearch extends SetupBrowser {

	static By cookies_accept = By.id("ccc-notify-accept");
	static By search_box = By.id("search-career-search-temp");
	static By language_select = By.xpath("//a[contains(text(),'Global')]");
	static By careerSearchButton = By.xpath("//button[@aria-label='career search open']");
	static By viewJobButton = By.xpath("//a[text()='View Job']");
	static By viewJobPageHeader = By.xpath("//div[text()='Java Developer']");

	static String resultText = "//div[contains(@class,'u-hidden')]//h6[text()='%s']";
	static String CareerPageTitle = "Search - Mott MacDonald";

	public static void navigateToCareerSearchPage(String careerSearchURL) {

		driver.manage().window().maximize();
		driver.navigate().to(careerSearchURL);
		wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
		wait.until(ExpectedConditions.elementToBeClickable(language_select)).click();
		log.info("Career Search page opened.");

	}

	public static void CareerPageSearch(String searchText) throws InterruptedException {

		String valTitle = driver.getTitle();
		Assert.assertTrue(valTitle.equals("Search - Mott MacDonald"));
		log.info("Career Search Page is loaded.");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(careerSearchButton));
		driver.findElement(search_box).sendKeys(searchText);
		wait.until(ExpectedConditions.elementToBeClickable(careerSearchButton));
		driver.findElement(careerSearchButton).click();
	}

	public static void closeBrowser() {

		driver.quit();
	}

	public static void verifySearchResults(String jobTitle) {

		String resultXpath = String.format(resultText, jobTitle);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(resultXpath)));
		log.info("Search results are displayed.");
		wait.until(ExpectedConditions.elementToBeClickable(viewJobButton));
		log.info("View Job Button is displayed.");
		driver.findElement(viewJobButton).click();

	}

	public static void verifyJobDetails(String jobTitle) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(viewJobPageHeader));
		log.info("Job Details are displayed.");

	}

}
