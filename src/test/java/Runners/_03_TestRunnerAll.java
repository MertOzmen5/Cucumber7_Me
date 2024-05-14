package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"}, // klasördeki bütün featurelar
        glue = {"StepDefinitions"}
)

public class _03_TestRunnerAll extends AbstractTestNGCucumberTests {
}
