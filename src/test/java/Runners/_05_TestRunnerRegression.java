package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest or @Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}

// group da or var ise : herhangi birisi olan çağrılır.
// group da end var ise : her iki grup adının da olması zorunlu iki grup adı olanlar çağrılır.