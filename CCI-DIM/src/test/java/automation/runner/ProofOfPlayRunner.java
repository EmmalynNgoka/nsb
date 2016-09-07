package automation.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "scenarios/ProofOfPlay.feature", glue = "automation", strict = false, format = {
		"pretty", "json:target/cucumber.json" })
public class ProofOfPlayRunner {

}
