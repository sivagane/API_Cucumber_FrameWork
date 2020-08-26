package stepdefnition;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	WebDriver driver;
	@Before()
	public void beforeScenario() throws ParseException {
		StepDefnition steps = new StepDefnition();
		steps.add_the_jira_create_Api_Payload_and("Mouse Action Not Performed", "Cannot Perform  the Mouse Action");
		steps.user_should_call_the_with_request("createIssueApi", "Post");
	}
	
	@After
	public void afterScenario() throws IOException {
		
		
	}

}
