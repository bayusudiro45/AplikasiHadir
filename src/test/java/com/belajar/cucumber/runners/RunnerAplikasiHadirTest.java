package com.belajar.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
        "src/test/resources/features/Overtime.feature",
        "src/test/resources/features/Leave.feature",
        "src/test/resources/features/Activity.feature"


}, glue = {
        "com.belajar.cucumber.definitions.overtime",
        "com.belajar.cucumber.definitions.leave",
        "com.belajar.cucumber.definitions.activity"
}, plugin = {
        "pretty",
        "html:target/cucumber-reporting/reports.html",
        "json:target/cucumber-reporting/reports.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RunnerAplikasiHadirTest extends AbstractTestNGCucumberTests {
}
