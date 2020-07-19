package io.humanscore.runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;

@Test
@CucumberOptions(
        plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        features = {"src/test/resources/features/profileMix.feature",
                "src/test/resources/features/login.feature",
                },
        monochrome = false,
        dryRun = false,
        glue="io/humanscore/stepdefs/")


public class ProfileMixTest extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src/test/configs/extent-report.xml"));
    }
}
