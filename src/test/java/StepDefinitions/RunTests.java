package StepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by asad.hasan on 16/08/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",glue = "StepDefinitions",plugin = "pretty")
public class RunTests {

}
