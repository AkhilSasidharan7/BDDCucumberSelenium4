package StepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.checkerframework.checker.units.qual.C;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mottMac.CareerSearch;
import mottMac.MottMacHome;
import mottMac.SetupBrowser;

public class StepDefinitions {

	@Before
	public static void setup() {
		SetupBrowser.setUp();
		
	}
	
	@Given("user opens career search page")
	public void user_opens_career_search_page() {
		CareerSearch.navigateToCareerSearchPage("https://www.mottmac.com/careers/search");
	}
	
	@When("user searches for {string}")
	public void user_searches_for(String jobTitle) throws InterruptedException {	
		CareerSearch.CareerPageSearch(jobTitle);
	}
	
	@Then("search result has {string}")
	public void search_result_has(String jobTitle) {
		CareerSearch.verifySearchResults(jobTitle);

	}

	@Then("verify the job details for {string} can be viewed")
	public void verify_the_job_details_for_can_be_viewed(String jobTitle) {
		CareerSearch.verifyJobDetails(jobTitle);
	    
	}


@Given("user opens MottMac application")
public void user_opens_mott_mac_application() {
	MottMacHome.launchApp();
}

@Then("verify all the links")
public void verify_all_the_links() throws InterruptedException, MalformedURLException, IOException, URISyntaxException {
   
	MottMacHome.verifyLinks();
}
	

	@After
	public void teardown() {

		SetupBrowser.closeBrowser();
	}

}
