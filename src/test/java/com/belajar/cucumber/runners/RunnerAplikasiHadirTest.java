package com.belajar.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
        "src/test/resources/features/01_Authentication.feature",
        // "src/test/resources/features/03_HistoryAbsensi.feature",
        // "src/test/resources/features/06_Lembur.feature",
        // "src/test/resources/features/07_Cuti.feature"
}, glue = {
        "com.belajar.cucumber.definitions.authentications",
        // "com.belajar.cucumber.definitions.absensi",
        // "com.belajar.cucumber.definitions.lembur",
        // "com.belajar.cucumber.definitions.cuti"
}, plugin = {
        "pretty",  
        "html:target/cucumber-reporting/reports.html", 
        "json:target/cucumber-reporting/reports.json", 
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RunnerAplikasiHadirTest extends AbstractTestNGCucumberTests {
}
