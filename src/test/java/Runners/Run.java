package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features.Tests/*"
        ,glue={"StepDefinitions"}
)

public class Run extends AbstractTestNGCucumberTests {

}