package runner;

import org.apache.commons.lang.math.JVMRandom;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.JVMReport;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources"}, glue= {"stepdefnition"}
,plugin= {"json:src\\test\\resources\\Reports\\cucumber.json"}
, dryRun=false)
public class TestRunner {
	
	@AfterClass
	public static void afterClass() {
		JVMReport.generateReport(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\cucumber.json");
	}

}
