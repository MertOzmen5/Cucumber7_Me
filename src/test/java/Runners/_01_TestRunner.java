package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature"}, // buraya çalıştırılacak feature files ın pathi verilecek.
        glue = {"StepDefinitions"} // Step definitions ın klasör adı yazılıyor.

)




public class _01_TestRunner extends AbstractTestNGCucumberTests {

}
