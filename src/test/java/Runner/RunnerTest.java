package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features",
				 glue={"StepDefinitions"},
				 publish=true,
				 dryRun=false,
				 tags="",
				 monochrome=true)
public class RunnerTest extends AbstractTestNGCucumberTests{

}
