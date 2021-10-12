package StepDefinition;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Featurefile",
        glue={"StepDefinition"},
        monochrome = true,
        plugin = {"pretty",
                "junit:target/JunitReports/report.xml",
                "json:target/JSONReports/report.json",
                "json:target/MyReport/report.xml",
                "html:target/HtmlReports"}
                )
    public class TestRunner {
    }
