package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= "src/test/resources/Features",
        glue = "StepDefinitions",
        monochrome = true,
        plugin = {"pretty","html:target/TestReport.html"}, 
        tags = "@Regression"
       
               
//@VerifyLinks,@Search,@Regression
)
public class MottMacRunner {
}
