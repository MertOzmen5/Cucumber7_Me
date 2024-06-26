package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                "src/test/java/FeatureFiles/_02_Country.feature",
                "src/test/java/FeatureFiles/_03_CitizenShip.feature"},
        glue = {"StepDefinitions"}
)

public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {
}


// features pathlerinin alınması : ilgili featureın üstüne gel sağ tıkla copy path/reference tıkla,Path From Content Root seç.