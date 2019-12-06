package org.qacademy.trello.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.qacademy.core.ui.DriverManager;

@CucumberOptions(
        glue = {"org.qacademy"},
        features = "src/test/resources/features",
        plugin = "pretty"
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeAllScenarios() {
    }


    @AfterTest
    public void afterAllScenarios() {
        DriverManager.getInstance().getDriver().quit();
    }
}
