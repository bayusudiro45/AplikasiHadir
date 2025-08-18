package com.belajar.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
        "src/test/resources/features/Authentication.feature",
        // "src/test/resources/features/Inventories.feature"
}, glue = {
        "com.belajar.cucumber.definitions.authentications",
        // "com.belajar.cucumber.definitions.inventories"
}, plugin = {
        "pretty",  
        "html:target/cucumber-reporting/reports.html", 
        "json:target/cucumber-reporting/reports.json", 
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RunnerAplikasiHadirTest extends AbstractTestNGCucumberTests {
}
