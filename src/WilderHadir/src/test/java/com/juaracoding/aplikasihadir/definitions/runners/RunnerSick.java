package com.juaracoding.aplikasihadir.definitions.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
            "src/test/resources/features/Sick.feature"
        },
        glue = {
            "com.juaracoding.aplikasihadir.definitions.user",
            "com.juaracoding.aplikasihadir.definitions.common",
            "com.juaracoding.aplikasihadir.utils"
        },
        tags = "@Sick or @Sakit",
        plugin = {
            "pretty",
            "html:target/cucumber-reports/cucumber.html",
            "json:target/cucumber-reports/cucumber.json",
            "timeline:target/cucumber-reports/timeline",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class RunnerSick extends AbstractTestNGCucumberTests {
}